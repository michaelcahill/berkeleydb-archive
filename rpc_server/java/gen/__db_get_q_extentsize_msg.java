/*
 * Automatically generated by jrpcgen 0.95.1 on 8/2/05 1:49 PM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://acplt.org/ks/remotetea.html for details
 */
package com.sleepycat.db.rpcserver;
import org.acplt.oncrpc.*;
import java.io.IOException;

public class __db_get_q_extentsize_msg implements XdrAble {
    public int dbpcl_id;

    public __db_get_q_extentsize_msg() {
    }

    public __db_get_q_extentsize_msg(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeInt(dbpcl_id);
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        dbpcl_id = xdr.xdrDecodeInt();
    }

}
// End of __db_get_q_extentsize_msg.java
