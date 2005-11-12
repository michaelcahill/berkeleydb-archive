/*
 * Automatically generated by jrpcgen 0.95.1 on 8/2/05 1:49 PM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://acplt.org/ks/remotetea.html for details
 */
package com.sleepycat.db.rpcserver;
import org.acplt.oncrpc.*;
import java.io.IOException;

public class __dbc_c_pget_msg implements XdrAble {
    public int dbccl_id;
    public int skeydlen;
    public int skeydoff;
    public int skeyulen;
    public int skeyflags;
    public byte [] skeydata;
    public int pkeydlen;
    public int pkeydoff;
    public int pkeyulen;
    public int pkeyflags;
    public byte [] pkeydata;
    public int datadlen;
    public int datadoff;
    public int dataulen;
    public int dataflags;
    public byte [] datadata;
    public int flags;

    public __dbc_c_pget_msg() {
    }

    public __dbc_c_pget_msg(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeInt(dbccl_id);
        xdr.xdrEncodeInt(skeydlen);
        xdr.xdrEncodeInt(skeydoff);
        xdr.xdrEncodeInt(skeyulen);
        xdr.xdrEncodeInt(skeyflags);
        xdr.xdrEncodeDynamicOpaque(skeydata);
        xdr.xdrEncodeInt(pkeydlen);
        xdr.xdrEncodeInt(pkeydoff);
        xdr.xdrEncodeInt(pkeyulen);
        xdr.xdrEncodeInt(pkeyflags);
        xdr.xdrEncodeDynamicOpaque(pkeydata);
        xdr.xdrEncodeInt(datadlen);
        xdr.xdrEncodeInt(datadoff);
        xdr.xdrEncodeInt(dataulen);
        xdr.xdrEncodeInt(dataflags);
        xdr.xdrEncodeDynamicOpaque(datadata);
        xdr.xdrEncodeInt(flags);
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        dbccl_id = xdr.xdrDecodeInt();
        skeydlen = xdr.xdrDecodeInt();
        skeydoff = xdr.xdrDecodeInt();
        skeyulen = xdr.xdrDecodeInt();
        skeyflags = xdr.xdrDecodeInt();
        skeydata = xdr.xdrDecodeDynamicOpaque();
        pkeydlen = xdr.xdrDecodeInt();
        pkeydoff = xdr.xdrDecodeInt();
        pkeyulen = xdr.xdrDecodeInt();
        pkeyflags = xdr.xdrDecodeInt();
        pkeydata = xdr.xdrDecodeDynamicOpaque();
        datadlen = xdr.xdrDecodeInt();
        datadoff = xdr.xdrDecodeInt();
        dataulen = xdr.xdrDecodeInt();
        dataflags = xdr.xdrDecodeInt();
        datadata = xdr.xdrDecodeDynamicOpaque();
        flags = xdr.xdrDecodeInt();
    }

}
// End of __dbc_c_pget_msg.java
