/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2000, 2015 Oracle and/or its affiliates.  All rights reserved.
 *
 */
package com.sleepycat.collections.test.serial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.collections.StoredMap;
import com.sleepycat.collections.TransactionRunner;
import com.sleepycat.collections.TransactionWorker;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.db.Database;
import com.sleepycat.db.DatabaseConfig;
import com.sleepycat.db.Environment;
import com.sleepycat.util.test.SharedTestUtils;
import com.sleepycat.util.test.TestBase;
import com.sleepycat.util.test.TestEnv;

/**
 * Runs part two of the StoredClassCatalogTest.  This part is run with the
 * new/updated version of TestSerial in the classpath.  It uses the
 * environment and databases created by StoredClassCatalogTestInit.  It
 * verifies that it can read objects serialized using the old class format,
 * and that it can create new objects with the new class format.
 *
 * @author Mark Hayes
 */
@RunWith(Parameterized.class)
public class StoredClassCatalogTest extends TestBase
    implements TransactionWorker {

    static final String CATALOG_FILE = "catalogtest-catalog.db";
    static final String STORE_FILE = "catalogtest-store.db";

    @Parameters
    public static List<Object[]> genParams() {
        List<Object[]> params = new ArrayList<Object[]>();
        for (TestEnv testEnv : TestEnv.ALL)
            params.add(new Object[]{testEnv});
        
        return params;
    }

    private TestEnv testEnv;
    private Environment env;
    private StoredClassCatalog catalog;
    private StoredClassCatalog catalog2;
    private Database store;
    private Map map;
    private TransactionRunner runner;

    public StoredClassCatalogTest(TestEnv testEnv) {

        this.testEnv = testEnv;
        customName = makeTestName(testEnv);
    }

    static String makeTestName(TestEnv testEnv) {
        return "StoredClassCatalogTest-" + testEnv.getName();
    }

    @Before
    public void setUp()
        throws Exception {

        SharedTestUtils.printTestName(customName);
        
        /* 
         * Copy the environment generated by StoredClassCatalogTestInit in
         * test dest dir, which is required to perform this test. 
         */
        SharedTestUtils.copyDir(
            new File(SharedTestUtils.getDestDir(), customName), 
            new File(SharedTestUtils.getTestDir(), customName));
        
        env = testEnv.open(customName, false);
        runner = new TransactionRunner(env);

        catalog = new StoredClassCatalog(openDb(CATALOG_FILE, false));
        catalog2 = new StoredClassCatalog(openDb("catalog2.db", true));

        SerialBinding keyBinding = new SerialBinding(catalog,
                                                  String.class);
        SerialBinding valueBinding = new SerialBinding(catalog,
                                                    TestSerial.class);
        store = openDb(STORE_FILE, false);

        map = new StoredMap(store, keyBinding, valueBinding, true);
    }

    private Database openDb(String file, boolean create)
        throws Exception {

        DatabaseConfig config = new DatabaseConfig();
        DbCompat.setTypeBtree(config);
        config.setTransactional(testEnv.isTxnMode());
        config.setAllowCreate(create);

        return DbCompat.testOpenDatabase(env, null, file, null, config);
    }

    @After
    public void tearDown() {

        try {
            if (catalog != null) {
                catalog.close();
                catalog.close(); // should have no effect
            }
            if (catalog2 != null) {
                catalog2.close();
            }
            if (store != null) {
                store.close();
            }
            if (env != null) {
                env.close();
            }
        } catch (Exception e) {
            System.err.println("Ignored exception during tearDown: ");
            e.printStackTrace();
        } finally {
            /* Ensure that GC can cleanup. */
            catalog = null;
            catalog2 = null;
            store = null;
            env = null;
            testEnv = null;
            map = null;
            runner = null;
        }
    }
    
    @Test
    public void runTest()
        throws Exception {

        runner.run(this);
    }

    public void doWork()
        throws Exception {

        TestSerial one = (TestSerial) map.get("one");
        TestSerial two = (TestSerial) map.get("two");
        assertNotNull(one);
        assertNotNull(two);
        assertEquals(one, two.getOther());
        assertNull(one.getStringField());
        assertNull(two.getStringField());

        TestSerial three = new TestSerial(two);
        assertNotNull(three.getStringField());
        map.put("three", three);
        three = (TestSerial) map.get("three");
        assertEquals(two, three.getOther());

        ObjectStreamClass desc = ObjectStreamClass.lookup(TestSerial.class);

        assertNotNull(catalog.getClassID(desc));
        assertNotNull(catalog.getClassID(desc));

        // test with empty catalog
        assertNotNull(catalog2.getClassID(desc));
        assertNotNull(catalog2.getClassID(desc));
    }
}
