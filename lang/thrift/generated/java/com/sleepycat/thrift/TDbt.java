/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sleepycat.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-10-9")
public class TDbt implements org.apache.thrift.TBase<TDbt, TDbt._Fields>, java.io.Serializable, Cloneable, Comparable<TDbt> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbt");

  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARTIAL_LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("partialLength", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PARTIAL_OFFSET_FIELD_DESC = new org.apache.thrift.protocol.TField("partialOffset", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField PARTIAL_FIELD_DESC = new org.apache.thrift.protocol.TField("partial", org.apache.thrift.protocol.TType.BOOL, (short)4);
  private static final org.apache.thrift.protocol.TField BLOB_FIELD_DESC = new org.apache.thrift.protocol.TField("blob", org.apache.thrift.protocol.TType.BOOL, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbtStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbtTupleSchemeFactory());
  }

  public ByteBuffer data; // optional
  public int partialLength; // optional
  public int partialOffset; // optional
  public boolean partial; // optional
  public boolean blob; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DATA((short)1, "data"),
    PARTIAL_LENGTH((short)2, "partialLength"),
    PARTIAL_OFFSET((short)3, "partialOffset"),
    PARTIAL((short)4, "partial"),
    BLOB((short)5, "blob");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DATA
          return DATA;
        case 2: // PARTIAL_LENGTH
          return PARTIAL_LENGTH;
        case 3: // PARTIAL_OFFSET
          return PARTIAL_OFFSET;
        case 4: // PARTIAL
          return PARTIAL;
        case 5: // BLOB
          return BLOB;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PARTIALLENGTH_ISSET_ID = 0;
  private static final int __PARTIALOFFSET_ISSET_ID = 1;
  private static final int __PARTIAL_ISSET_ID = 2;
  private static final int __BLOB_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DATA,_Fields.PARTIAL_LENGTH,_Fields.PARTIAL_OFFSET,_Fields.PARTIAL,_Fields.BLOB};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.PARTIAL_LENGTH, new org.apache.thrift.meta_data.FieldMetaData("partialLength", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PARTIAL_OFFSET, new org.apache.thrift.meta_data.FieldMetaData("partialOffset", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PARTIAL, new org.apache.thrift.meta_data.FieldMetaData("partial", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BLOB, new org.apache.thrift.meta_data.FieldMetaData("blob", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbt.class, metaDataMap);
  }

  public TDbt() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbt(TDbt other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetData()) {
      this.data = org.apache.thrift.TBaseHelper.copyBinary(other.data);
    }
    this.partialLength = other.partialLength;
    this.partialOffset = other.partialOffset;
    this.partial = other.partial;
    this.blob = other.blob;
  }

  public TDbt deepCopy() {
    return new TDbt(this);
  }

  @Override
  public void clear() {
    this.data = null;
    setPartialLengthIsSet(false);
    this.partialLength = 0;
    setPartialOffsetIsSet(false);
    this.partialOffset = 0;
    setPartialIsSet(false);
    this.partial = false;
    setBlobIsSet(false);
    this.blob = false;
  }

  public byte[] getData() {
    setData(org.apache.thrift.TBaseHelper.rightSize(data));
    return data == null ? null : data.array();
  }

  public ByteBuffer bufferForData() {
    return org.apache.thrift.TBaseHelper.copyBinary(data);
  }

  public TDbt setData(byte[] data) {
    this.data = data == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(data, data.length));
    return this;
  }

  public TDbt setData(ByteBuffer data) {
    this.data = org.apache.thrift.TBaseHelper.copyBinary(data);
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public int getPartialLength() {
    return this.partialLength;
  }

  public TDbt setPartialLength(int partialLength) {
    this.partialLength = partialLength;
    setPartialLengthIsSet(true);
    return this;
  }

  public void unsetPartialLength() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARTIALLENGTH_ISSET_ID);
  }

  /** Returns true if field partialLength is set (has been assigned a value) and false otherwise */
  public boolean isSetPartialLength() {
    return EncodingUtils.testBit(__isset_bitfield, __PARTIALLENGTH_ISSET_ID);
  }

  public void setPartialLengthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARTIALLENGTH_ISSET_ID, value);
  }

  public int getPartialOffset() {
    return this.partialOffset;
  }

  public TDbt setPartialOffset(int partialOffset) {
    this.partialOffset = partialOffset;
    setPartialOffsetIsSet(true);
    return this;
  }

  public void unsetPartialOffset() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARTIALOFFSET_ISSET_ID);
  }

  /** Returns true if field partialOffset is set (has been assigned a value) and false otherwise */
  public boolean isSetPartialOffset() {
    return EncodingUtils.testBit(__isset_bitfield, __PARTIALOFFSET_ISSET_ID);
  }

  public void setPartialOffsetIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARTIALOFFSET_ISSET_ID, value);
  }

  public boolean isPartial() {
    return this.partial;
  }

  public TDbt setPartial(boolean partial) {
    this.partial = partial;
    setPartialIsSet(true);
    return this;
  }

  public void unsetPartial() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARTIAL_ISSET_ID);
  }

  /** Returns true if field partial is set (has been assigned a value) and false otherwise */
  public boolean isSetPartial() {
    return EncodingUtils.testBit(__isset_bitfield, __PARTIAL_ISSET_ID);
  }

  public void setPartialIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARTIAL_ISSET_ID, value);
  }

  public boolean isBlob() {
    return this.blob;
  }

  public TDbt setBlob(boolean blob) {
    this.blob = blob;
    setBlobIsSet(true);
    return this;
  }

  public void unsetBlob() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BLOB_ISSET_ID);
  }

  /** Returns true if field blob is set (has been assigned a value) and false otherwise */
  public boolean isSetBlob() {
    return EncodingUtils.testBit(__isset_bitfield, __BLOB_ISSET_ID);
  }

  public void setBlobIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BLOB_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((ByteBuffer)value);
      }
      break;

    case PARTIAL_LENGTH:
      if (value == null) {
        unsetPartialLength();
      } else {
        setPartialLength((Integer)value);
      }
      break;

    case PARTIAL_OFFSET:
      if (value == null) {
        unsetPartialOffset();
      } else {
        setPartialOffset((Integer)value);
      }
      break;

    case PARTIAL:
      if (value == null) {
        unsetPartial();
      } else {
        setPartial((Boolean)value);
      }
      break;

    case BLOB:
      if (value == null) {
        unsetBlob();
      } else {
        setBlob((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATA:
      return getData();

    case PARTIAL_LENGTH:
      return Integer.valueOf(getPartialLength());

    case PARTIAL_OFFSET:
      return Integer.valueOf(getPartialOffset());

    case PARTIAL:
      return Boolean.valueOf(isPartial());

    case BLOB:
      return Boolean.valueOf(isBlob());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATA:
      return isSetData();
    case PARTIAL_LENGTH:
      return isSetPartialLength();
    case PARTIAL_OFFSET:
      return isSetPartialOffset();
    case PARTIAL:
      return isSetPartial();
    case BLOB:
      return isSetBlob();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbt)
      return this.equals((TDbt)that);
    return false;
  }

  public boolean equals(TDbt that) {
    if (that == null)
      return false;

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    boolean this_present_partialLength = true && this.isSetPartialLength();
    boolean that_present_partialLength = true && that.isSetPartialLength();
    if (this_present_partialLength || that_present_partialLength) {
      if (!(this_present_partialLength && that_present_partialLength))
        return false;
      if (this.partialLength != that.partialLength)
        return false;
    }

    boolean this_present_partialOffset = true && this.isSetPartialOffset();
    boolean that_present_partialOffset = true && that.isSetPartialOffset();
    if (this_present_partialOffset || that_present_partialOffset) {
      if (!(this_present_partialOffset && that_present_partialOffset))
        return false;
      if (this.partialOffset != that.partialOffset)
        return false;
    }

    boolean this_present_partial = true && this.isSetPartial();
    boolean that_present_partial = true && that.isSetPartial();
    if (this_present_partial || that_present_partial) {
      if (!(this_present_partial && that_present_partial))
        return false;
      if (this.partial != that.partial)
        return false;
    }

    boolean this_present_blob = true && this.isSetBlob();
    boolean that_present_blob = true && that.isSetBlob();
    if (this_present_blob || that_present_blob) {
      if (!(this_present_blob && that_present_blob))
        return false;
      if (this.blob != that.blob)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_data = true && (isSetData());
    list.add(present_data);
    if (present_data)
      list.add(data);

    boolean present_partialLength = true && (isSetPartialLength());
    list.add(present_partialLength);
    if (present_partialLength)
      list.add(partialLength);

    boolean present_partialOffset = true && (isSetPartialOffset());
    list.add(present_partialOffset);
    if (present_partialOffset)
      list.add(partialOffset);

    boolean present_partial = true && (isSetPartial());
    list.add(present_partial);
    if (present_partial)
      list.add(partial);

    boolean present_blob = true && (isSetBlob());
    list.add(present_blob);
    if (present_blob)
      list.add(blob);

    return list.hashCode();
  }

  @Override
  public int compareTo(TDbt other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartialLength()).compareTo(other.isSetPartialLength());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartialLength()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partialLength, other.partialLength);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartialOffset()).compareTo(other.isSetPartialOffset());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartialOffset()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partialOffset, other.partialOffset);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartial()).compareTo(other.isSetPartial());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartial()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partial, other.partial);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBlob()).compareTo(other.isSetBlob());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBlob()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.blob, other.blob);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TDbt(");
    boolean first = true;

    if (isSetData()) {
      sb.append("data:");
      if (this.data == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.data, sb);
      }
      first = false;
    }
    if (isSetPartialLength()) {
      if (!first) sb.append(", ");
      sb.append("partialLength:");
      sb.append(this.partialLength);
      first = false;
    }
    if (isSetPartialOffset()) {
      if (!first) sb.append(", ");
      sb.append("partialOffset:");
      sb.append(this.partialOffset);
      first = false;
    }
    if (isSetPartial()) {
      if (!first) sb.append(", ");
      sb.append("partial:");
      sb.append(this.partial);
      first = false;
    }
    if (isSetBlob()) {
      if (!first) sb.append(", ");
      sb.append("blob:");
      sb.append(this.blob);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDbtStandardSchemeFactory implements SchemeFactory {
    public TDbtStandardScheme getScheme() {
      return new TDbtStandardScheme();
    }
  }

  private static class TDbtStandardScheme extends StandardScheme<TDbt> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbt struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data = iprot.readBinary();
              struct.setDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARTIAL_LENGTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.partialLength = iprot.readI32();
              struct.setPartialLengthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARTIAL_OFFSET
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.partialOffset = iprot.readI32();
              struct.setPartialOffsetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PARTIAL
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.partial = iprot.readBool();
              struct.setPartialIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BLOB
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.blob = iprot.readBool();
              struct.setBlobIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbt struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.data != null) {
        if (struct.isSetData()) {
          oprot.writeFieldBegin(DATA_FIELD_DESC);
          oprot.writeBinary(struct.data);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetPartialLength()) {
        oprot.writeFieldBegin(PARTIAL_LENGTH_FIELD_DESC);
        oprot.writeI32(struct.partialLength);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPartialOffset()) {
        oprot.writeFieldBegin(PARTIAL_OFFSET_FIELD_DESC);
        oprot.writeI32(struct.partialOffset);
        oprot.writeFieldEnd();
      }
      if (struct.isSetPartial()) {
        oprot.writeFieldBegin(PARTIAL_FIELD_DESC);
        oprot.writeBool(struct.partial);
        oprot.writeFieldEnd();
      }
      if (struct.isSetBlob()) {
        oprot.writeFieldBegin(BLOB_FIELD_DESC);
        oprot.writeBool(struct.blob);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbtTupleSchemeFactory implements SchemeFactory {
    public TDbtTupleScheme getScheme() {
      return new TDbtTupleScheme();
    }
  }

  private static class TDbtTupleScheme extends TupleScheme<TDbt> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbt struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetData()) {
        optionals.set(0);
      }
      if (struct.isSetPartialLength()) {
        optionals.set(1);
      }
      if (struct.isSetPartialOffset()) {
        optionals.set(2);
      }
      if (struct.isSetPartial()) {
        optionals.set(3);
      }
      if (struct.isSetBlob()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetData()) {
        oprot.writeBinary(struct.data);
      }
      if (struct.isSetPartialLength()) {
        oprot.writeI32(struct.partialLength);
      }
      if (struct.isSetPartialOffset()) {
        oprot.writeI32(struct.partialOffset);
      }
      if (struct.isSetPartial()) {
        oprot.writeBool(struct.partial);
      }
      if (struct.isSetBlob()) {
        oprot.writeBool(struct.blob);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbt struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.data = iprot.readBinary();
        struct.setDataIsSet(true);
      }
      if (incoming.get(1)) {
        struct.partialLength = iprot.readI32();
        struct.setPartialLengthIsSet(true);
      }
      if (incoming.get(2)) {
        struct.partialOffset = iprot.readI32();
        struct.setPartialOffsetIsSet(true);
      }
      if (incoming.get(3)) {
        struct.partial = iprot.readBool();
        struct.setPartialIsSet(true);
      }
      if (incoming.get(4)) {
        struct.blob = iprot.readBool();
        struct.setBlobIsSet(true);
      }
    }
  }

}

