/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package server.msg.auto;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header implements org.apache.thrift.TBase<Header, Header._Fields>, java.io.Serializable, Cloneable, Comparable<Header> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Header");

  private static final org.apache.thrift.protocol.TField ORDER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("orderId", org.apache.thrift.protocol.TType.I64, (short)10);
  private static final org.apache.thrift.protocol.TField SK_FIELD_DESC = new org.apache.thrift.protocol.TField("sk", org.apache.thrift.protocol.TType.STRING, (short)20);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HeaderStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HeaderTupleSchemeFactory());
  }

  public long orderId; // required
  public String sk; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ORDER_ID((short)10, "orderId"),
    SK((short)20, "sk");

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
        case 10: // ORDER_ID
          return ORDER_ID;
        case 20: // SK
          return SK;
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
  private static final int __ORDERID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ORDER_ID, new org.apache.thrift.meta_data.FieldMetaData("orderId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.SK, new org.apache.thrift.meta_data.FieldMetaData("sk", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Header.class, metaDataMap);
  }

  public Header() {
  }

  public Header(
    long orderId,
    String sk)
  {
    this();
    this.orderId = orderId;
    setOrderIdIsSet(true);
    this.sk = sk;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Header(Header other) {
    __isset_bitfield = other.__isset_bitfield;
    this.orderId = other.orderId;
    if (other.isSetSk()) {
      this.sk = other.sk;
    }
  }

  public Header deepCopy() {
    return new Header(this);
  }

  @Override
  public void clear() {
    setOrderIdIsSet(false);
    this.orderId = 0;
    this.sk = null;
  }

  public long getOrderId() {
    return this.orderId;
  }

  public Header setOrderId(long orderId) {
    this.orderId = orderId;
    setOrderIdIsSet(true);
    return this;
  }

  public void unsetOrderId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ORDERID_ISSET_ID);
  }

  /** Returns true if field orderId is set (has been assigned a value) and false otherwise */
  public boolean isSetOrderId() {
    return EncodingUtils.testBit(__isset_bitfield, __ORDERID_ISSET_ID);
  }

  public void setOrderIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ORDERID_ISSET_ID, value);
  }

  public String getSk() {
    return this.sk;
  }

  public Header setSk(String sk) {
    this.sk = sk;
    return this;
  }

  public void unsetSk() {
    this.sk = null;
  }

  /** Returns true if field sk is set (has been assigned a value) and false otherwise */
  public boolean isSetSk() {
    return this.sk != null;
  }

  public void setSkIsSet(boolean value) {
    if (!value) {
      this.sk = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ORDER_ID:
      if (value == null) {
        unsetOrderId();
      } else {
        setOrderId((Long)value);
      }
      break;

    case SK:
      if (value == null) {
        unsetSk();
      } else {
        setSk((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ORDER_ID:
      return Long.valueOf(getOrderId());

    case SK:
      return getSk();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ORDER_ID:
      return isSetOrderId();
    case SK:
      return isSetSk();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Header)
      return this.equals((Header)that);
    return false;
  }

  public boolean equals(Header that) {
    if (that == null)
      return false;

    boolean this_present_orderId = true;
    boolean that_present_orderId = true;
    if (this_present_orderId || that_present_orderId) {
      if (!(this_present_orderId && that_present_orderId))
        return false;
      if (this.orderId != that.orderId)
        return false;
    }

    boolean this_present_sk = true && this.isSetSk();
    boolean that_present_sk = true && that.isSetSk();
    if (this_present_sk || that_present_sk) {
      if (!(this_present_sk && that_present_sk))
        return false;
      if (!this.sk.equals(that.sk))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Header other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOrderId()).compareTo(other.isSetOrderId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrderId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orderId, other.orderId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSk()).compareTo(other.isSetSk());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSk()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sk, other.sk);
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
    StringBuilder sb = new StringBuilder("Header(");
    boolean first = true;

    sb.append("orderId:");
    sb.append(this.orderId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sk:");
    if (this.sk == null) {
      sb.append("null");
    } else {
      sb.append(this.sk);
    }
    first = false;
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

  private static class HeaderStandardSchemeFactory implements SchemeFactory {
    public HeaderStandardScheme getScheme() {
      return new HeaderStandardScheme();
    }
  }

  private static class HeaderStandardScheme extends StandardScheme<Header> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Header struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 10: // ORDER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.orderId = iprot.readI64();
              struct.setOrderIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 20: // SK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sk = iprot.readString();
              struct.setSkIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Header struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ORDER_ID_FIELD_DESC);
      oprot.writeI64(struct.orderId);
      oprot.writeFieldEnd();
      if (struct.sk != null) {
        oprot.writeFieldBegin(SK_FIELD_DESC);
        oprot.writeString(struct.sk);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HeaderTupleSchemeFactory implements SchemeFactory {
    public HeaderTupleScheme getScheme() {
      return new HeaderTupleScheme();
    }
  }

  private static class HeaderTupleScheme extends TupleScheme<Header> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Header struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetOrderId()) {
        optionals.set(0);
      }
      if (struct.isSetSk()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetOrderId()) {
        oprot.writeI64(struct.orderId);
      }
      if (struct.isSetSk()) {
        oprot.writeString(struct.sk);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Header struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.orderId = iprot.readI64();
        struct.setOrderIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.sk = iprot.readString();
        struct.setSkIsSet(true);
      }
    }
  }

}
