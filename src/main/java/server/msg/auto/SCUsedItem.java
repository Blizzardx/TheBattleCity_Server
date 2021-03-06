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

public class SCUsedItem implements org.apache.thrift.TBase<SCUsedItem, SCUsedItem._Fields>, java.io.Serializable, Cloneable, Comparable<SCUsedItem> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SCUsedItem");

  private static final org.apache.thrift.protocol.TField PLAYER_UID_FIELD_DESC = new org.apache.thrift.protocol.TField("playerUid", org.apache.thrift.protocol.TType.I32, (short)10);
  private static final org.apache.thrift.protocol.TField ITEM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("itemId", org.apache.thrift.protocol.TType.I32, (short)20);
  private static final org.apache.thrift.protocol.TField POSITION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("positionId", org.apache.thrift.protocol.TType.I32, (short)32);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SCUsedItemStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SCUsedItemTupleSchemeFactory());
  }

  public int playerUid; // required
  public int itemId; // required
  public int positionId; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PLAYER_UID((short)10, "playerUid"),
    ITEM_ID((short)20, "itemId"),
    POSITION_ID((short)32, "positionId");

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
        case 10: // PLAYER_UID
          return PLAYER_UID;
        case 20: // ITEM_ID
          return ITEM_ID;
        case 32: // POSITION_ID
          return POSITION_ID;
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
  private static final int __PLAYERUID_ISSET_ID = 0;
  private static final int __ITEMID_ISSET_ID = 1;
  private static final int __POSITIONID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PLAYER_UID, new org.apache.thrift.meta_data.FieldMetaData("playerUid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ITEM_ID, new org.apache.thrift.meta_data.FieldMetaData("itemId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.POSITION_ID, new org.apache.thrift.meta_data.FieldMetaData("positionId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SCUsedItem.class, metaDataMap);
  }

  public SCUsedItem() {
  }

  public SCUsedItem(
    int playerUid,
    int itemId,
    int positionId)
  {
    this();
    this.playerUid = playerUid;
    setPlayerUidIsSet(true);
    this.itemId = itemId;
    setItemIdIsSet(true);
    this.positionId = positionId;
    setPositionIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SCUsedItem(SCUsedItem other) {
    __isset_bitfield = other.__isset_bitfield;
    this.playerUid = other.playerUid;
    this.itemId = other.itemId;
    this.positionId = other.positionId;
  }

  public SCUsedItem deepCopy() {
    return new SCUsedItem(this);
  }

  @Override
  public void clear() {
    setPlayerUidIsSet(false);
    this.playerUid = 0;
    setItemIdIsSet(false);
    this.itemId = 0;
    setPositionIdIsSet(false);
    this.positionId = 0;
  }

  public int getPlayerUid() {
    return this.playerUid;
  }

  public SCUsedItem setPlayerUid(int playerUid) {
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

  public int getItemId() {
    return this.itemId;
  }

  public SCUsedItem setItemId(int itemId) {
    this.itemId = itemId;
    setItemIdIsSet(true);
    return this;
  }

  public void unsetItemId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ITEMID_ISSET_ID);
  }

  /** Returns true if field itemId is set (has been assigned a value) and false otherwise */
  public boolean isSetItemId() {
    return EncodingUtils.testBit(__isset_bitfield, __ITEMID_ISSET_ID);
  }

  public void setItemIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ITEMID_ISSET_ID, value);
  }

  public int getPositionId() {
    return this.positionId;
  }

  public SCUsedItem setPositionId(int positionId) {
    this.positionId = positionId;
    setPositionIdIsSet(true);
    return this;
  }

  public void unsetPositionId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __POSITIONID_ISSET_ID);
  }

  /** Returns true if field positionId is set (has been assigned a value) and false otherwise */
  public boolean isSetPositionId() {
    return EncodingUtils.testBit(__isset_bitfield, __POSITIONID_ISSET_ID);
  }

  public void setPositionIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __POSITIONID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PLAYER_UID:
      if (value == null) {
        unsetPlayerUid();
      } else {
        setPlayerUid((Integer)value);
      }
      break;

    case ITEM_ID:
      if (value == null) {
        unsetItemId();
      } else {
        setItemId((Integer)value);
      }
      break;

    case POSITION_ID:
      if (value == null) {
        unsetPositionId();
      } else {
        setPositionId((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PLAYER_UID:
      return Integer.valueOf(getPlayerUid());

    case ITEM_ID:
      return Integer.valueOf(getItemId());

    case POSITION_ID:
      return Integer.valueOf(getPositionId());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PLAYER_UID:
      return isSetPlayerUid();
    case ITEM_ID:
      return isSetItemId();
    case POSITION_ID:
      return isSetPositionId();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SCUsedItem)
      return this.equals((SCUsedItem)that);
    return false;
  }

  public boolean equals(SCUsedItem that) {
    if (that == null)
      return false;

    boolean this_present_playerUid = true;
    boolean that_present_playerUid = true;
    if (this_present_playerUid || that_present_playerUid) {
      if (!(this_present_playerUid && that_present_playerUid))
        return false;
      if (this.playerUid != that.playerUid)
        return false;
    }

    boolean this_present_itemId = true;
    boolean that_present_itemId = true;
    if (this_present_itemId || that_present_itemId) {
      if (!(this_present_itemId && that_present_itemId))
        return false;
      if (this.itemId != that.itemId)
        return false;
    }

    boolean this_present_positionId = true;
    boolean that_present_positionId = true;
    if (this_present_positionId || that_present_positionId) {
      if (!(this_present_positionId && that_present_positionId))
        return false;
      if (this.positionId != that.positionId)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SCUsedItem other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetItemId()).compareTo(other.isSetItemId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItemId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itemId, other.itemId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPositionId()).compareTo(other.isSetPositionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPositionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.positionId, other.positionId);
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
    StringBuilder sb = new StringBuilder("SCUsedItem(");
    boolean first = true;

    sb.append("playerUid:");
    sb.append(this.playerUid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("itemId:");
    sb.append(this.itemId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("positionId:");
    sb.append(this.positionId);
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

  private static class SCUsedItemStandardSchemeFactory implements SchemeFactory {
    public SCUsedItemStandardScheme getScheme() {
      return new SCUsedItemStandardScheme();
    }
  }

  private static class SCUsedItemStandardScheme extends StandardScheme<SCUsedItem> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SCUsedItem struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 10: // PLAYER_UID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.playerUid = iprot.readI32();
              struct.setPlayerUidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 20: // ITEM_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.itemId = iprot.readI32();
              struct.setItemIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 32: // POSITION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.positionId = iprot.readI32();
              struct.setPositionIdIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SCUsedItem struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PLAYER_UID_FIELD_DESC);
      oprot.writeI32(struct.playerUid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ITEM_ID_FIELD_DESC);
      oprot.writeI32(struct.itemId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(POSITION_ID_FIELD_DESC);
      oprot.writeI32(struct.positionId);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SCUsedItemTupleSchemeFactory implements SchemeFactory {
    public SCUsedItemTupleScheme getScheme() {
      return new SCUsedItemTupleScheme();
    }
  }

  private static class SCUsedItemTupleScheme extends TupleScheme<SCUsedItem> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SCUsedItem struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPlayerUid()) {
        optionals.set(0);
      }
      if (struct.isSetItemId()) {
        optionals.set(1);
      }
      if (struct.isSetPositionId()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPlayerUid()) {
        oprot.writeI32(struct.playerUid);
      }
      if (struct.isSetItemId()) {
        oprot.writeI32(struct.itemId);
      }
      if (struct.isSetPositionId()) {
        oprot.writeI32(struct.positionId);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SCUsedItem struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.playerUid = iprot.readI32();
        struct.setPlayerUidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.itemId = iprot.readI32();
        struct.setItemIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.positionId = iprot.readI32();
        struct.setPositionIdIsSet(true);
      }
    }
  }

}

