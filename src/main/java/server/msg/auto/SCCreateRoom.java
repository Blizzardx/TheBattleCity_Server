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

public class SCCreateRoom implements org.apache.thrift.TBase<SCCreateRoom, SCCreateRoom._Fields>, java.io.Serializable, Cloneable, Comparable<SCCreateRoom> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SCCreateRoom");

  private static final org.apache.thrift.protocol.TField IS_SUCCEED_FIELD_DESC = new org.apache.thrift.protocol.TField("isSucceed", org.apache.thrift.protocol.TType.BOOL, (short)10);
  private static final org.apache.thrift.protocol.TField ERROR_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("errorInfo", org.apache.thrift.protocol.TType.STRING, (short)20);
  private static final org.apache.thrift.protocol.TField PLAYER_UID_FIELD_DESC = new org.apache.thrift.protocol.TField("playerUid", org.apache.thrift.protocol.TType.I32, (short)30);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SCCreateRoomStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SCCreateRoomTupleSchemeFactory());
  }

  public boolean isSucceed; // required
  public String errorInfo; // required
  public int playerUid; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    IS_SUCCEED((short)10, "isSucceed"),
    ERROR_INFO((short)20, "errorInfo"),
    PLAYER_UID((short)30, "playerUid");

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
        case 10: // IS_SUCCEED
          return IS_SUCCEED;
        case 20: // ERROR_INFO
          return ERROR_INFO;
        case 30: // PLAYER_UID
          return PLAYER_UID;
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
  private static final int __ISSUCCEED_ISSET_ID = 0;
  private static final int __PLAYERUID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IS_SUCCEED, new org.apache.thrift.meta_data.FieldMetaData("isSucceed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.ERROR_INFO, new org.apache.thrift.meta_data.FieldMetaData("errorInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PLAYER_UID, new org.apache.thrift.meta_data.FieldMetaData("playerUid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SCCreateRoom.class, metaDataMap);
  }

  public SCCreateRoom() {
  }

  public SCCreateRoom(
    boolean isSucceed,
    String errorInfo,
    int playerUid)
  {
    this();
    this.isSucceed = isSucceed;
    setIsSucceedIsSet(true);
    this.errorInfo = errorInfo;
    this.playerUid = playerUid;
    setPlayerUidIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SCCreateRoom(SCCreateRoom other) {
    __isset_bitfield = other.__isset_bitfield;
    this.isSucceed = other.isSucceed;
    if (other.isSetErrorInfo()) {
      this.errorInfo = other.errorInfo;
    }
    this.playerUid = other.playerUid;
  }

  public SCCreateRoom deepCopy() {
    return new SCCreateRoom(this);
  }

  @Override
  public void clear() {
    setIsSucceedIsSet(false);
    this.isSucceed = false;
    this.errorInfo = null;
    setPlayerUidIsSet(false);
    this.playerUid = 0;
  }

  public boolean isIsSucceed() {
    return this.isSucceed;
  }

  public SCCreateRoom setIsSucceed(boolean isSucceed) {
    this.isSucceed = isSucceed;
    setIsSucceedIsSet(true);
    return this;
  }

  public void unsetIsSucceed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISSUCCEED_ISSET_ID);
  }

  /** Returns true if field isSucceed is set (has been assigned a value) and false otherwise */
  public boolean isSetIsSucceed() {
    return EncodingUtils.testBit(__isset_bitfield, __ISSUCCEED_ISSET_ID);
  }

  public void setIsSucceedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISSUCCEED_ISSET_ID, value);
  }

  public String getErrorInfo() {
    return this.errorInfo;
  }

  public SCCreateRoom setErrorInfo(String errorInfo) {
    this.errorInfo = errorInfo;
    return this;
  }

  public void unsetErrorInfo() {
    this.errorInfo = null;
  }

  /** Returns true if field errorInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorInfo() {
    return this.errorInfo != null;
  }

  public void setErrorInfoIsSet(boolean value) {
    if (!value) {
      this.errorInfo = null;
    }
  }

  public int getPlayerUid() {
    return this.playerUid;
  }

  public SCCreateRoom setPlayerUid(int playerUid) {
    this.playerUid = playerUid;
    setPlayerUidIsSet(true);
    return this;
  }

  public void unsetPlayerUid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PLAYERUID_ISSET_ID);
  }

  /** Returns true if field playerUid is set (has been assigned a value) and false otherwise */
  public boolean isSetPlayerUid() {
    return EncodingUtils.testBit(__isset_bitfield, __PLAYERUID_ISSET_ID);
  }

  public void setPlayerUidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PLAYERUID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case IS_SUCCEED:
      if (value == null) {
        unsetIsSucceed();
      } else {
        setIsSucceed((Boolean)value);
      }
      break;

    case ERROR_INFO:
      if (value == null) {
        unsetErrorInfo();
      } else {
        setErrorInfo((String)value);
      }
      break;

    case PLAYER_UID:
      if (value == null) {
        unsetPlayerUid();
      } else {
        setPlayerUid((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case IS_SUCCEED:
      return Boolean.valueOf(isIsSucceed());

    case ERROR_INFO:
      return getErrorInfo();

    case PLAYER_UID:
      return Integer.valueOf(getPlayerUid());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case IS_SUCCEED:
      return isSetIsSucceed();
    case ERROR_INFO:
      return isSetErrorInfo();
    case PLAYER_UID:
      return isSetPlayerUid();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SCCreateRoom)
      return this.equals((SCCreateRoom)that);
    return false;
  }

  public boolean equals(SCCreateRoom that) {
    if (that == null)
      return false;

    boolean this_present_isSucceed = true;
    boolean that_present_isSucceed = true;
    if (this_present_isSucceed || that_present_isSucceed) {
      if (!(this_present_isSucceed && that_present_isSucceed))
        return false;
      if (this.isSucceed != that.isSucceed)
        return false;
    }

    boolean this_present_errorInfo = true && this.isSetErrorInfo();
    boolean that_present_errorInfo = true && that.isSetErrorInfo();
    if (this_present_errorInfo || that_present_errorInfo) {
      if (!(this_present_errorInfo && that_present_errorInfo))
        return false;
      if (!this.errorInfo.equals(that.errorInfo))
        return false;
    }

    boolean this_present_playerUid = true;
    boolean that_present_playerUid = true;
    if (this_present_playerUid || that_present_playerUid) {
      if (!(this_present_playerUid && that_present_playerUid))
        return false;
      if (this.playerUid != that.playerUid)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SCCreateRoom other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIsSucceed()).compareTo(other.isSetIsSucceed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsSucceed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isSucceed, other.isSucceed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrorInfo()).compareTo(other.isSetErrorInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorInfo, other.errorInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlayerUid()).compareTo(other.isSetPlayerUid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlayerUid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.playerUid, other.playerUid);
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
    StringBuilder sb = new StringBuilder("SCCreateRoom(");
    boolean first = true;

    sb.append("isSucceed:");
    sb.append(this.isSucceed);
    first = false;
    if (!first) sb.append(", ");
    sb.append("errorInfo:");
    if (this.errorInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.errorInfo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("playerUid:");
    sb.append(this.playerUid);
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

  private static class SCCreateRoomStandardSchemeFactory implements SchemeFactory {
    public SCCreateRoomStandardScheme getScheme() {
      return new SCCreateRoomStandardScheme();
    }
  }

  private static class SCCreateRoomStandardScheme extends StandardScheme<SCCreateRoom> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SCCreateRoom struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 10: // IS_SUCCEED
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isSucceed = iprot.readBool();
              struct.setIsSucceedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 20: // ERROR_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorInfo = iprot.readString();
              struct.setErrorInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 30: // PLAYER_UID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.playerUid = iprot.readI32();
              struct.setPlayerUidIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SCCreateRoom struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(IS_SUCCEED_FIELD_DESC);
      oprot.writeBool(struct.isSucceed);
      oprot.writeFieldEnd();
      if (struct.errorInfo != null) {
        oprot.writeFieldBegin(ERROR_INFO_FIELD_DESC);
        oprot.writeString(struct.errorInfo);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PLAYER_UID_FIELD_DESC);
      oprot.writeI32(struct.playerUid);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SCCreateRoomTupleSchemeFactory implements SchemeFactory {
    public SCCreateRoomTupleScheme getScheme() {
      return new SCCreateRoomTupleScheme();
    }
  }

  private static class SCCreateRoomTupleScheme extends TupleScheme<SCCreateRoom> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SCCreateRoom struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetIsSucceed()) {
        optionals.set(0);
      }
      if (struct.isSetErrorInfo()) {
        optionals.set(1);
      }
      if (struct.isSetPlayerUid()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetIsSucceed()) {
        oprot.writeBool(struct.isSucceed);
      }
      if (struct.isSetErrorInfo()) {
        oprot.writeString(struct.errorInfo);
      }
      if (struct.isSetPlayerUid()) {
        oprot.writeI32(struct.playerUid);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SCCreateRoom struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.isSucceed = iprot.readBool();
        struct.setIsSucceedIsSet(true);
      }
      if (incoming.get(1)) {
        struct.errorInfo = iprot.readString();
        struct.setErrorInfoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.playerUid = iprot.readI32();
        struct.setPlayerUidIsSet(true);
      }
    }
  }

}

