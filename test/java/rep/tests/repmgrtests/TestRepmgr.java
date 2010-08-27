/*-
 * See the file LICENSE for redistribution information.
 * 
 * Copyright (c) 2010 Oracle and/or its affiliates.  All rights reserved.
 *
 */

package repmgrtests;


import java.io.File;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.sleepycat.db.BtreeStats;
import com.sleepycat.db.Database;
import com.sleepycat.db.DatabaseConfig;
import com.sleepycat.db.DatabaseEntry;
import com.sleepycat.db.DatabaseType;
import com.sleepycat.db.Environment;
import com.sleepycat.db.EnvironmentConfig;
import com.sleepycat.db.EventHandlerAdapter;
import com.sleepycat.db.ReplicationHostAddress;
import com.sleepycat.db.ReplicationManagerStartPolicy;
import com.sleepycat.db.VerboseConfig;

/**
 * Regression test for #15788.  No fiddler funny-business, just a
 * straightforward test of internal init with a healthy amount of data
 * (enough to flood the outgoing TCP queue, so that we're force to
 * invoke our new waiting feature).
 */
public class TestRepmgr extends TestCase {
	private static final String TEST_DIR_NAME = "TESTDIR";

	private File testdir;
	class MyEventHandler extends EventHandlerAdapter {
		private boolean done = false;
		private boolean panic = false;
		
		@Override
		synchronized public void handleRepStartupDoneEvent() {
			done = true;
			notifyAll();
		}
		
		@Override
		synchronized public void handlePanicEvent() {
			done = true;
			panic = true;
			notifyAll();
		}
		
		synchronized void await() throws Exception {
			while (!done) { wait(); }
			if (panic)
				throw new Exception("aborted by panic in DB");
		}
	}

	@Before
	public void setUp() throws Exception {
		testdir = new File(TEST_DIR_NAME);
		Util.rm_rf(testdir);
		testdir.mkdir();
	}
	
	@After
	public void tearDown() throws Exception {
		// Hmm, this kind of interesting.  What we really want
		// is to clean up the env directories *only* if the
		// test passed.  If it failed, it may be useful to
		// keep it around for analysis.
		// 
//		if (completed)
//			Util.rm_rf(testdir);
	}

	public void testEnvCreate() throws Exception {
		// TODO: move this to a test runner.
		if (Boolean.getBoolean("debug.pause")) {
			// force DB to be loaded first (is this necessary?)
			Environment.getVersionString();
			System.out.println(".> ");
			System.in.read();
		}
		
		int[] testPorts = Util.findAvailablePorts(2);
		int masterPort = testPorts[0];
		int clientPort = testPorts[1];
		
		EnvironmentConfig ec = makeBasicConfig();
		ec.setReplicationLimit(100000000);
		ec.setReplicationManagerLocalSite(new ReplicationHostAddress("localhost", masterPort));
		Environment master = new Environment(mkdir("master"), ec);
		master.replicationManagerStart(3, ReplicationManagerStartPolicy.REP_MASTER);
		
		DatabaseConfig dc = new DatabaseConfig();
		dc.setTransactional(true);
		dc.setAllowCreate(true);
		dc.setType(DatabaseType.BTREE);
		Database db = master.openDatabase(null, "test.db", null, dc);
		
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		value.setData("This is a reasonably long string.  The controller is responsible for maintaining the view, and for interpreting UI events and turning them into operations on the model.".getBytes());
		int i = 0;
		BtreeStats stats = (BtreeStats)db.getStats(null, null);
		while (stats.getPageCount() < 400) {
			String k = "The record number is: " + ++i;
			key.setData(k.getBytes());
			db.put(null, key, value);
			stats = (BtreeStats)db.getStats(null, null);
		}
		db.close();

		ec = makeBasicConfig();
//		ec.setReplicationRequestMin(200);
//		ec.setReplicationRequestMax(1000);
		ec.setReplicationManagerLocalSite(new ReplicationHostAddress("localhost", clientPort));
		ec.replicationManagerAddRemoteSite(new ReplicationHostAddress("localhost", masterPort), false);
		MyEventHandler mon = new MyEventHandler();
		ec.setEventHandler(mon);
		Environment client = new Environment(mkdir("client"), ec);
		client.replicationManagerStart(2, ReplicationManagerStartPolicy.REP_CLIENT);
		
//		ReplicationHostAddress[] sites = client.getReplicationManagerSiteList();
//		assertEquals(1, sites.length);
//		assertEquals("localhost", sites[0].host);
//		assertEquals(masterSpoofPort, sites[0].port);

		mon.await();
		
//		sites = master.getReplicationManagerSiteList();
//		assertEquals(1, sites.length);
//		assertEquals("localhost", sites[0].host);
//		assertEquals(clientPort, sites[0].port);
		
//		ec.setReplicationRequestMax(128);
//		ec.setReplicationRequestMin(4);
//		client.setConfig(ec);
//		System.out.println(client.getReplicationStats(StatsConfig.DEFAULT));
		
		client.close();
		master.close();
	}
	
	public static EnvironmentConfig makeBasicConfig() {
		EnvironmentConfig ec = new EnvironmentConfig();
		ec.setAllowCreate(true);
		ec.setInitializeCache(true);
		ec.setInitializeLocking(true);
		ec.setInitializeLogging(true);
		ec.setInitializeReplication(true);
		ec.setTransactional(true);
		ec.setThreaded(true);
		ec.setReplicationNumSites(3);
		if (Boolean.getBoolean("VERB_REPLICATION"))
			ec.setVerbose(VerboseConfig.REPLICATION, true);
		return (ec);
	}
	
	public File mkdir(String dname) {
		File f = new File(testdir, dname);
		f.mkdir();
		return f;
	}
}
