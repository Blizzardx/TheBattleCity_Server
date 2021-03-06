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

public class ItemGenFundamental implements org.apache.thrift.TBase<ItemGenFundamental, ItemGenFundamental._Fields>, java.io.Serializable, Cloneable, Comparable<ItemGenFundamental> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ItemGenFundamental");

  private static final org.apache.thrift.protocol.TField POSITION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("positionId", org.apache.thrift.protocol.TType.LIST, (short)10);
  private static final org.apache.thrift.protocol.TField ITEM_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("itemList", org.apache.thrift.protocol.TType.LIST, (short)20);
  private static final org.apache.thrift.protocol.TField MAX_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("maxCount", org.apache.thrift.protocol.TType.I32, (short)30);
  private static final org.apache.thrift.protocol.TField GEN_PRE_TIME_ITEM_COUNT_MIN_FIELD_DESC = new org.apache.thrift.protocol.TField("genPreTimeItemCountMin", org.apache.thrift.protocol.TType.I32, (short)40);
  private static final org.apache.thrift.protocol.TField GEN_PRE_TIME_ITEM_COUNT_MAX_FIELD_DESC = new org.apache.thrift.protocol.TField("genPreTimeItemCountMax", org.apache.thrift.protocol.TType.I32, (short)50);
  private static final org.apache.thrift.protocol.TField TRIGGER_DELTA_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("triggerDeltaTime", org.apache.thrift.protocol.TType.I32, (short)60);
  private static final org.apache.thrift.protocol.TField INIT_ITEM_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("initItemCount", org.apache.thrift.protocol.TType.I32, (short)70);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ItemGenFundamentalStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ItemGenFundamentalTupleSchemeFactory());
  }

  public List<Integer> positionId; // required
  public List<Integer> itemList; // required
  public int maxCount; // required
  public int genPreTimeItemCountMin; // required
  public int genPreTimeItemCountMax; // required
  public int triggerDeltaTime; // required
  public int initItemCount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    POSITION_ID((short)10, "positionId"),
    ITEM_LIST((short)20, "itemList"),
    MAX_COUNT((short)30, "maxCount"),
    GEN_PRE_TIME_ITEM_COUNT_MIN((short)40, "genPreTimeItemCountMin"),
    GEN_PRE_TIME_ITEM_COUNT_MAX((short)50, "genPreTimeItemCountMax"),
    TRIGGER_DELTA_TIME((short)60, "triggerDeltaTime"),
    INIT_ITEM_COUNT((short)70, "initItemCount");

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
        case 10: // POSITION_ID
          return POSITION_ID;
        case 20: // ITEM_LIST
          return ITEM_LIST;
        case 30: // MAX_COUNT
          return MAX_COUNT;
        case 40: // GEN_PRE_TIME_ITEM_COUNT_MIN
          return GEN_PRE_TIME_ITEM_COUNT_MIN;
        case 50: // GEN_PRE_TIME_ITEM_COUNT_MAX
          return GEN_PRE_TIME_ITEM_COUNT_MAX;
        case 60: // TRIGGER_DELTA_TIME
          return TRIGGER_DELTA_TIME;
        case 70: // INIT_ITEM_COUNT
          return INIT_ITEM_COUNT;
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
  private static final int __MAXCOUNT_ISSET_ID = 0;
  private static final int __GENPRETIMEITEMCOUNTMIN_ISSET_ID = 1;
  private static final int __GENPRETIMEITEMCOUNTMAX_ISSET_ID = 2;
  private static final int __TRIGGERDELTATIME_ISSET_ID = 3;
  private static final int __INITITEMCOUNT_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.POSITION_ID, new org.apache.thrift.meta_data.FieldMetaData("positionId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.ITEM_LIST, new org.apache.thrift.meta_data.FieldMetaData("itemList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.MAX_COUNT, new org.apache.thrift.meta_data.FieldMetaData("maxCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GEN_PRE_TIME_ITEM_COUNT_MIN, new org.apache.thrift.meta_data.FieldMetaData("genPreTimeItemCountMin", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GEN_PRE_TIME_ITEM_COUNT_MAX, new org.apache.thrift.meta_data.FieldMetaData("genPreTimeItemCountMax", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TRIGGER_DELTA_TIME, new org.apache.thrift.meta_data.FieldMetaData("triggerDeltaTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.INIT_ITEM_COUNT, new org.apache.thrift.meta_data.FieldMetaData("initItemCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ItemGenFundamental.class, metaDataMap);
  }

  public ItemGenFundamental() {
  }

  public ItemGenFundamental(
    List<Integer> positionId,
    List<Integer> itemList,
    int maxCount,
    int genPreTimeItemCountMin,
    int genPreTimeItemCountMax,
    int triggerDeltaTime,
    int initItemCount)
  {
    this();
    this.positionId = positionId;
    this.itemList = itemList;
    this.maxCount = maxCount;
    setMaxCountIsSet(true);
    this.genPreTimeItemCountMin = genPreTimeItemCountMin;
    setGenPreTimeItemCountMinIsSet(true);
    this.genPreTimeItemCountMax = genPreTimeItemCountMax;
    setGenPreTimeItemCountMaxIsSet(true);
    this.triggerDeltaTime = triggerDeltaTime;
    setTriggerDeltaTimeIsSet(true);
    this.initItemCount = initItemCount;
    setInitItemCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ItemGenFundamental(ItemGenFundamental other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPositionId()) {
      List<Integer> __this__positionId = new ArrayList<Integer>(other.positionId);
      this.positionId = __this__positionId;
    }
    if (other.isSetItemList()) {
      List<Integer> __this__itemList = new ArrayList<Integer>(other.itemList);
      this.itemList = __this__itemList;
    }
    this.maxCount = other.maxCount;
    this.genPreTimeItemCountMin = other.genPreTimeItemCountMin;
    this.genPreTimeItemCountMax = other.genPreTimeItemCountMax;
    this.triggerDeltaTime = other.triggerDeltaTime;
    this.initItemCount = other.initItemCount;
  }

  public ItemGenFundamental deepCopy() {
    return new ItemGenFundamental(this);
  }

  @Override
  public void clear() {
    this.positionId = null;
    this.itemList = null;
    setMaxCountIsSet(false);
    this.maxCount = 0;
    setGenPreTimeItemCountMinIsSet(false);
    this.genPreTimeItemCountMin = 0;
    setGenPreTimeItemCountMaxIsSet(false);
    this.genPreTimeItemCountMax = 0;
    setTriggerDeltaTimeIsSet(false);
    this.triggerDeltaTime = 0;
    setInitItemCountIsSet(false);
    this.initItemCount = 0;
  }

  public int getPositionIdSize() {
    return (this.positionId == null) ? 0 : this.positionId.size();
  }

  public java.util.Iterator<Integer> getPositionIdIterator() {
    return (this.positionId == null) ? null : this.positionId.iterator();
  }

  public void addToPositionId(int elem) {
    if (this.positionId == null) {
      this.positionId = new ArrayList<Integer>();
    }
    this.positionId.add(elem);
  }

  public List<Integer> getPositionId() {
    return this.positionId;
  }

  public ItemGenFundamental setPositionId(List<Integer> positionId) {
    this.positionId = positionId;
    return this;
  }

  public void unsetPositionId() {
    this.positionId = null;
  }

  /** Returns true if field positionId is set (has been assigned a value) and false otherwise */
  public boolean isSetPositionId() {
    return this.positionId != null;
  }

  public void setPositionIdIsSet(boolean value) {
    if (!value) {
      this.positionId = null;
    }
  }

  public int getItemListSize() {
    return (this.itemList == null) ? 0 : this.itemList.size();
  }

  public java.util.Iterator<Integer> getItemListIterator() {
    return (this.itemList == null) ? null : this.itemList.iterator();
  }

  public void addToItemList(int elem) {
    if (this.itemList == null) {
      this.itemList = new ArrayList<Integer>();
    }
    this.itemList.add(elem);
  }

  public List<Integer> getItemList() {
    return this.itemList;
  }

  public ItemGenFundamental setItemList(List<Integer> itemList) {
    this.itemList = itemList;
    return this;
  }

  public void unsetItemList() {
    this.itemList = null;
  }

  /** Returns true if field itemList is set (has been assigned a value) and false otherwise */
  public boolean isSetItemList() {
    return this.itemList != null;
  }

  public void setItemListIsSet(boolean value) {
    if (!value) {
      this.itemList = null;
    }
  }

  public int getMaxCount() {
    return this.maxCount;
  }

  public ItemGenFundamental setMaxCount(int maxCount) {
    this.maxCount = maxCount;
    setMaxCountIsSet(true);
    return this;
  }

  public void unsetMaxCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAXCOUNT_ISSET_ID);
  }

  /** Returns true if field maxCount is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxCount() {
    return EncodingUtils.testBit(__isset_bitfield, __MAXCOUNT_ISSET_ID);
  }

  public void setMaxCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAXCOUNT_ISSET_ID, value);
  }

  public int getGenPreTimeItemCountMin() {
    return this.genPreTimeItemCountMin;
  }

  public ItemGenFundamental setGenPreTimeItemCountMin(int genPreTimeItemCountMin) {
    this.genPreTimeItemCountMin = genPreTimeItemCountMin;
    setGenPreTimeItemCountMinIsSet(true);
    return this;
  }

  public void unsetGenPreTimeItemCountMin() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMIN_ISSET_ID);
  }

  /** Returns true if field genPreTimeItemCountMin is set (has been assigned a value) and false otherwise */
  public boolean isSetGenPreTimeItemCountMin() {
    return EncodingUtils.testBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMIN_ISSET_ID);
  }

  public void setGenPreTimeItemCountMinIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMIN_ISSET_ID, value);
  }

  public int getGenPreTimeItemCountMax() {
    return this.genPreTimeItemCountMax;
  }

  public ItemGenFundamental setGenPreTimeItemCountMax(int genPreTimeItemCountMax) {
    this.genPreTimeItemCountMax = genPreTimeItemCountMax;
    setGenPreTimeItemCountMaxIsSet(true);
    return this;
  }

  public void unsetGenPreTimeItemCountMax() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMAX_ISSET_ID);
  }

  /** Returns true if field genPreTimeItemCountMax is set (has been assigned a value) and false otherwise */
  public boolean isSetGenPreTimeItemCountMax() {
    return EncodingUtils.testBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMAX_ISSET_ID);
  }

  public void setGenPreTimeItemCountMaxIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GENPRETIMEITEMCOUNTMAX_ISSET_ID, value);
  }

  public int getTriggerDeltaTime() {
    return this.triggerDeltaTime;
  }

  public ItemGenFundamental setTriggerDeltaTime(int triggerDeltaTime) {
    this.triggerDeltaTime = triggerDeltaTime;
    setTriggerDeltaTimeIsSet(true);
    return this;
  }

  public void unsetTriggerDeltaTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TRIGGERDELTATIME_ISSET_ID);
  }

  /** Returns true if field triggerDeltaTime is set (has been assigned a value) and false otherwise */
  public boolean isSetTriggerDeltaTime() {
    return EncodingUtils.testBit(__isset_bitfield, __TRIGGERDELTATIME_ISSET_ID);
  }

  public void setTriggerDeltaTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TRIGGERDELTATIME_ISSET_ID, value);
  }

  public int getInitItemCount() {
    return this.initItemCount;
  }

  public ItemGenFundamental setInitItemCount(int initItemCount) {
    this.initItemCount = initItemCount;
    setInitItemCountIsSet(true);
    return this;
  }

  public void unsetInitItemCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INITITEMCOUNT_ISSET_ID);
  }

  /** Returns true if field initItemCount is set (has been assigned a value) and false otherwise */
  public boolean isSetInitItemCount() {
    return EncodingUtils.testBit(__isset_bitfield, __INITITEMCOUNT_ISSET_ID);
  }

  public void setInitItemCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INITITEMCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case POSITION_ID:
      if (value == null) {
        unsetPositionId();
      } else {
        setPositionId((List<Integer>)value);
      }
      break;

    case ITEM_LIST:
      if (value == null) {
        unsetItemList();
      } else {
        setItemList((List<Integer>)value);
      }
      break;

    case MAX_COUNT:
      if (value == null) {
        unsetMaxCount();
      } else {
        setMaxCount((Integer)value);
      }
      break;

    case GEN_PRE_TIME_ITEM_COUNT_MIN:
      if (value == null) {
        unsetGenPreTimeItemCountMin();
      } else {
        setGenPreTimeItemCountMin((Integer)value);
      }
      break;

    case GEN_PRE_TIME_ITEM_COUNT_MAX:
      if (value == null) {
        unsetGenPreTimeItemCountMax();
      } else {
        setGenPreTimeItemCountMax((Integer)value);
      }
      break;

    case TRIGGER_DELTA_TIME:
      if (value == null) {
        unsetTriggerDeltaTime();
      } else {
        setTriggerDeltaTime((Integer)value);
      }
      break;

    case INIT_ITEM_COUNT:
      if (value == null) {
        unsetInitItemCount();
      } else {
        setInitItemCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case POSITION_ID:
      return getPositionId();

    case ITEM_LIST:
      return getItemList();

    case MAX_COUNT:
      return Integer.valueOf(getMaxCount());

    case GEN_PRE_TIME_ITEM_COUNT_MIN:
      return Integer.valueOf(getGenPreTimeItemCountMin());

    case GEN_PRE_TIME_ITEM_COUNT_MAX:
      return Integer.valueOf(getGenPreTimeItemCountMax());

    case TRIGGER_DELTA_TIME:
      return Integer.valueOf(getTriggerDeltaTime());

    case INIT_ITEM_COUNT:
      return Integer.valueOf(getInitItemCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case POSITION_ID:
      return isSetPositionId();
    case ITEM_LIST:
      return isSetItemList();
    case MAX_COUNT:
      return isSetMaxCount();
    case GEN_PRE_TIME_ITEM_COUNT_MIN:
      return isSetGenPreTimeItemCountMin();
    case GEN_PRE_TIME_ITEM_COUNT_MAX:
      return isSetGenPreTimeItemCountMax();
    case TRIGGER_DELTA_TIME:
      return isSetTriggerDeltaTime();
    case INIT_ITEM_COUNT:
      return isSetInitItemCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ItemGenFundamental)
      return this.equals((ItemGenFundamental)that);
    return false;
  }

  public boolean equals(ItemGenFundamental that) {
    if (that == null)
      return false;

    boolean this_present_positionId = true && this.isSetPositionId();
    boolean that_present_positionId = true && that.isSetPositionId();
    if (this_present_positionId || that_present_positionId) {
      if (!(this_present_positionId && that_present_positionId))
        return false;
      if (!this.positionId.equals(that.positionId))
        return false;
    }

    boolean this_present_itemList = true && this.isSetItemList();
    boolean that_present_itemList = true && that.isSetItemList();
    if (this_present_itemList || that_present_itemList) {
      if (!(this_present_itemList && that_present_itemList))
        return false;
      if (!this.itemList.equals(that.itemList))
        return false;
    }

    boolean this_present_maxCount = true;
    boolean that_present_maxCount = true;
    if (this_present_maxCount || that_present_maxCount) {
      if (!(this_present_maxCount && that_present_maxCount))
        return false;
      if (this.maxCount != that.maxCount)
        return false;
    }

    boolean this_present_genPreTimeItemCountMin = true;
    boolean that_present_genPreTimeItemCountMin = true;
    if (this_present_genPreTimeItemCountMin || that_present_genPreTimeItemCountMin) {
      if (!(this_present_genPreTimeItemCountMin && that_present_genPreTimeItemCountMin))
        return false;
      if (this.genPreTimeItemCountMin != that.genPreTimeItemCountMin)
        return false;
    }

    boolean this_present_genPreTimeItemCountMax = true;
    boolean that_present_genPreTimeItemCountMax = true;
    if (this_present_genPreTimeItemCountMax || that_present_genPreTimeItemCountMax) {
      if (!(this_present_genPreTimeItemCountMax && that_present_genPreTimeItemCountMax))
        return false;
      if (this.genPreTimeItemCountMax != that.genPreTimeItemCountMax)
        return false;
    }

    boolean this_present_triggerDeltaTime = true;
    boolean that_present_triggerDeltaTime = true;
    if (this_present_triggerDeltaTime || that_present_triggerDeltaTime) {
      if (!(this_present_triggerDeltaTime && that_present_triggerDeltaTime))
        return false;
      if (this.triggerDeltaTime != that.triggerDeltaTime)
        return false;
    }

    boolean this_present_initItemCount = true;
    boolean that_present_initItemCount = true;
    if (this_present_initItemCount || that_present_initItemCount) {
      if (!(this_present_initItemCount && that_present_initItemCount))
        return false;
      if (this.initItemCount != that.initItemCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ItemGenFundamental other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetItemList()).compareTo(other.isSetItemList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItemList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itemList, other.itemList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxCount()).compareTo(other.isSetMaxCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxCount, other.maxCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGenPreTimeItemCountMin()).compareTo(other.isSetGenPreTimeItemCountMin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGenPreTimeItemCountMin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.genPreTimeItemCountMin, other.genPreTimeItemCountMin);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGenPreTimeItemCountMax()).compareTo(other.isSetGenPreTimeItemCountMax());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGenPreTimeItemCountMax()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.genPreTimeItemCountMax, other.genPreTimeItemCountMax);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTriggerDeltaTime()).compareTo(other.isSetTriggerDeltaTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTriggerDeltaTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.triggerDeltaTime, other.triggerDeltaTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInitItemCount()).compareTo(other.isSetInitItemCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInitItemCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.initItemCount, other.initItemCount);
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
    StringBuilder sb = new StringBuilder("ItemGenFundamental(");
    boolean first = true;

    sb.append("positionId:");
    if (this.positionId == null) {
      sb.append("null");
    } else {
      sb.append(this.positionId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("itemList:");
    if (this.itemList == null) {
      sb.append("null");
    } else {
      sb.append(this.itemList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("maxCount:");
    sb.append(this.maxCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("genPreTimeItemCountMin:");
    sb.append(this.genPreTimeItemCountMin);
    first = false;
    if (!first) sb.append(", ");
    sb.append("genPreTimeItemCountMax:");
    sb.append(this.genPreTimeItemCountMax);
    first = false;
    if (!first) sb.append(", ");
    sb.append("triggerDeltaTime:");
    sb.append(this.triggerDeltaTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("initItemCount:");
    sb.append(this.initItemCount);
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

  private static class ItemGenFundamentalStandardSchemeFactory implements SchemeFactory {
    public ItemGenFundamentalStandardScheme getScheme() {
      return new ItemGenFundamentalStandardScheme();
    }
  }

  private static class ItemGenFundamentalStandardScheme extends StandardScheme<ItemGenFundamental> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ItemGenFundamental struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 10: // POSITION_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.positionId = new ArrayList<Integer>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  int _elem2;
                  _elem2 = iprot.readI32();
                  struct.positionId.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setPositionIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 20: // ITEM_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.itemList = new ArrayList<Integer>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  int _elem5;
                  _elem5 = iprot.readI32();
                  struct.itemList.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setItemListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 30: // MAX_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.maxCount = iprot.readI32();
              struct.setMaxCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 40: // GEN_PRE_TIME_ITEM_COUNT_MIN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.genPreTimeItemCountMin = iprot.readI32();
              struct.setGenPreTimeItemCountMinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 50: // GEN_PRE_TIME_ITEM_COUNT_MAX
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.genPreTimeItemCountMax = iprot.readI32();
              struct.setGenPreTimeItemCountMaxIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 60: // TRIGGER_DELTA_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.triggerDeltaTime = iprot.readI32();
              struct.setTriggerDeltaTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 70: // INIT_ITEM_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.initItemCount = iprot.readI32();
              struct.setInitItemCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ItemGenFundamental struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.positionId != null) {
        oprot.writeFieldBegin(POSITION_ID_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.positionId.size()));
          for (int _iter6 : struct.positionId)
          {
            oprot.writeI32(_iter6);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.itemList != null) {
        oprot.writeFieldBegin(ITEM_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.itemList.size()));
          for (int _iter7 : struct.itemList)
          {
            oprot.writeI32(_iter7);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(MAX_COUNT_FIELD_DESC);
      oprot.writeI32(struct.maxCount);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GEN_PRE_TIME_ITEM_COUNT_MIN_FIELD_DESC);
      oprot.writeI32(struct.genPreTimeItemCountMin);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GEN_PRE_TIME_ITEM_COUNT_MAX_FIELD_DESC);
      oprot.writeI32(struct.genPreTimeItemCountMax);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TRIGGER_DELTA_TIME_FIELD_DESC);
      oprot.writeI32(struct.triggerDeltaTime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(INIT_ITEM_COUNT_FIELD_DESC);
      oprot.writeI32(struct.initItemCount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ItemGenFundamentalTupleSchemeFactory implements SchemeFactory {
    public ItemGenFundamentalTupleScheme getScheme() {
      return new ItemGenFundamentalTupleScheme();
    }
  }

  private static class ItemGenFundamentalTupleScheme extends TupleScheme<ItemGenFundamental> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ItemGenFundamental struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPositionId()) {
        optionals.set(0);
      }
      if (struct.isSetItemList()) {
        optionals.set(1);
      }
      if (struct.isSetMaxCount()) {
        optionals.set(2);
      }
      if (struct.isSetGenPreTimeItemCountMin()) {
        optionals.set(3);
      }
      if (struct.isSetGenPreTimeItemCountMax()) {
        optionals.set(4);
      }
      if (struct.isSetTriggerDeltaTime()) {
        optionals.set(5);
      }
      if (struct.isSetInitItemCount()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetPositionId()) {
        {
          oprot.writeI32(struct.positionId.size());
          for (int _iter8 : struct.positionId)
          {
            oprot.writeI32(_iter8);
          }
        }
      }
      if (struct.isSetItemList()) {
        {
          oprot.writeI32(struct.itemList.size());
          for (int _iter9 : struct.itemList)
          {
            oprot.writeI32(_iter9);
          }
        }
      }
      if (struct.isSetMaxCount()) {
        oprot.writeI32(struct.maxCount);
      }
      if (struct.isSetGenPreTimeItemCountMin()) {
        oprot.writeI32(struct.genPreTimeItemCountMin);
      }
      if (struct.isSetGenPreTimeItemCountMax()) {
        oprot.writeI32(struct.genPreTimeItemCountMax);
      }
      if (struct.isSetTriggerDeltaTime()) {
        oprot.writeI32(struct.triggerDeltaTime);
      }
      if (struct.isSetInitItemCount()) {
        oprot.writeI32(struct.initItemCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ItemGenFundamental struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.positionId = new ArrayList<Integer>(_list10.size);
          for (int _i11 = 0; _i11 < _list10.size; ++_i11)
          {
            int _elem12;
            _elem12 = iprot.readI32();
            struct.positionId.add(_elem12);
          }
        }
        struct.setPositionIdIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.itemList = new ArrayList<Integer>(_list13.size);
          for (int _i14 = 0; _i14 < _list13.size; ++_i14)
          {
            int _elem15;
            _elem15 = iprot.readI32();
            struct.itemList.add(_elem15);
          }
        }
        struct.setItemListIsSet(true);
      }
      if (incoming.get(2)) {
        struct.maxCount = iprot.readI32();
        struct.setMaxCountIsSet(true);
      }
      if (incoming.get(3)) {
        struct.genPreTimeItemCountMin = iprot.readI32();
        struct.setGenPreTimeItemCountMinIsSet(true);
      }
      if (incoming.get(4)) {
        struct.genPreTimeItemCountMax = iprot.readI32();
        struct.setGenPreTimeItemCountMaxIsSet(true);
      }
      if (incoming.get(5)) {
        struct.triggerDeltaTime = iprot.readI32();
        struct.setTriggerDeltaTimeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.initItemCount = iprot.readI32();
        struct.setInitItemCountIsSet(true);
      }
    }
  }

}

