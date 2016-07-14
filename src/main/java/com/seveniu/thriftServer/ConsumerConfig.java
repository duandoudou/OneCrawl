/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.seveniu.thriftServer;

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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-07-06")
public class ConsumerConfig implements org.apache.thrift.TBase<ConsumerConfig, ConsumerConfig._Fields>, java.io.Serializable, Cloneable, Comparable<ConsumerConfig> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ConsumerConfig");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DUPLICATE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("duplicateUrl", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DONE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("doneUrl", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField STATISTIC_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("statisticUrl", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField TASK_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("taskUrl", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField HOST_FIELD_DESC = new org.apache.thrift.protocol.TField("host", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("port", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ConsumerConfigStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ConsumerConfigTupleSchemeFactory());
  }

  public String name; // required
  public String type; // required
  public String duplicateUrl; // optional
  public String doneUrl; // optional
  public String statisticUrl; // optional
  public String taskUrl; // optional
  public String host; // optional
  public int port; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    TYPE((short)2, "type"),
    DUPLICATE_URL((short)3, "duplicateUrl"),
    DONE_URL((short)4, "doneUrl"),
    STATISTIC_URL((short)5, "statisticUrl"),
    TASK_URL((short)6, "taskUrl"),
    HOST((short)7, "host"),
    PORT((short)8, "port");

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
        case 1: // NAME
          return NAME;
        case 2: // TYPE
          return TYPE;
        case 3: // DUPLICATE_URL
          return DUPLICATE_URL;
        case 4: // DONE_URL
          return DONE_URL;
        case 5: // STATISTIC_URL
          return STATISTIC_URL;
        case 6: // TASK_URL
          return TASK_URL;
        case 7: // HOST
          return HOST;
        case 8: // PORT
          return PORT;
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
  private static final int __PORT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.DUPLICATE_URL,_Fields.DONE_URL,_Fields.STATISTIC_URL,_Fields.TASK_URL,_Fields.HOST,_Fields.PORT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DUPLICATE_URL, new org.apache.thrift.meta_data.FieldMetaData("duplicateUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DONE_URL, new org.apache.thrift.meta_data.FieldMetaData("doneUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATISTIC_URL, new org.apache.thrift.meta_data.FieldMetaData("statisticUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TASK_URL, new org.apache.thrift.meta_data.FieldMetaData("taskUrl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOST, new org.apache.thrift.meta_data.FieldMetaData("host", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT, new org.apache.thrift.meta_data.FieldMetaData("port", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ConsumerConfig.class, metaDataMap);
  }

  public ConsumerConfig() {
  }

  public ConsumerConfig(
    String name,
    String type)
  {
    this();
    this.name = name;
    this.type = type;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ConsumerConfig(ConsumerConfig other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetDuplicateUrl()) {
      this.duplicateUrl = other.duplicateUrl;
    }
    if (other.isSetDoneUrl()) {
      this.doneUrl = other.doneUrl;
    }
    if (other.isSetStatisticUrl()) {
      this.statisticUrl = other.statisticUrl;
    }
    if (other.isSetTaskUrl()) {
      this.taskUrl = other.taskUrl;
    }
    if (other.isSetHost()) {
      this.host = other.host;
    }
    this.port = other.port;
  }

  public ConsumerConfig deepCopy() {
    return new ConsumerConfig(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.type = null;
    this.duplicateUrl = null;
    this.doneUrl = null;
    this.statisticUrl = null;
    this.taskUrl = null;
    this.host = null;
    setPortIsSet(false);
    this.port = 0;
  }

  public String getName() {
    return this.name;
  }

  public ConsumerConfig setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getType() {
    return this.type;
  }

  public ConsumerConfig setType(String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public String getDuplicateUrl() {
    return this.duplicateUrl;
  }

  public ConsumerConfig setDuplicateUrl(String duplicateUrl) {
    this.duplicateUrl = duplicateUrl;
    return this;
  }

  public void unsetDuplicateUrl() {
    this.duplicateUrl = null;
  }

  /** Returns true if field duplicateUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetDuplicateUrl() {
    return this.duplicateUrl != null;
  }

  public void setDuplicateUrlIsSet(boolean value) {
    if (!value) {
      this.duplicateUrl = null;
    }
  }

  public String getDoneUrl() {
    return this.doneUrl;
  }

  public ConsumerConfig setDoneUrl(String doneUrl) {
    this.doneUrl = doneUrl;
    return this;
  }

  public void unsetDoneUrl() {
    this.doneUrl = null;
  }

  /** Returns true if field doneUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetDoneUrl() {
    return this.doneUrl != null;
  }

  public void setDoneUrlIsSet(boolean value) {
    if (!value) {
      this.doneUrl = null;
    }
  }

  public String getStatisticUrl() {
    return this.statisticUrl;
  }

  public ConsumerConfig setStatisticUrl(String statisticUrl) {
    this.statisticUrl = statisticUrl;
    return this;
  }

  public void unsetStatisticUrl() {
    this.statisticUrl = null;
  }

  /** Returns true if field statisticUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetStatisticUrl() {
    return this.statisticUrl != null;
  }

  public void setStatisticUrlIsSet(boolean value) {
    if (!value) {
      this.statisticUrl = null;
    }
  }

  public String getTaskUrl() {
    return this.taskUrl;
  }

  public ConsumerConfig setTaskUrl(String taskUrl) {
    this.taskUrl = taskUrl;
    return this;
  }

  public void unsetTaskUrl() {
    this.taskUrl = null;
  }

  /** Returns true if field taskUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskUrl() {
    return this.taskUrl != null;
  }

  public void setTaskUrlIsSet(boolean value) {
    if (!value) {
      this.taskUrl = null;
    }
  }

  public String getHost() {
    return this.host;
  }

  public ConsumerConfig setHost(String host) {
    this.host = host;
    return this;
  }

  public void unsetHost() {
    this.host = null;
  }

  /** Returns true if field host is set (has been assigned a value) and false otherwise */
  public boolean isSetHost() {
    return this.host != null;
  }

  public void setHostIsSet(boolean value) {
    if (!value) {
      this.host = null;
    }
  }

  public int getPort() {
    return this.port;
  }

  public ConsumerConfig setPort(int port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been assigned a value) and false otherwise */
  public boolean isSetPort() {
    return EncodingUtils.testBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PORT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((String)value);
      }
      break;

    case DUPLICATE_URL:
      if (value == null) {
        unsetDuplicateUrl();
      } else {
        setDuplicateUrl((String)value);
      }
      break;

    case DONE_URL:
      if (value == null) {
        unsetDoneUrl();
      } else {
        setDoneUrl((String)value);
      }
      break;

    case STATISTIC_URL:
      if (value == null) {
        unsetStatisticUrl();
      } else {
        setStatisticUrl((String)value);
      }
      break;

    case TASK_URL:
      if (value == null) {
        unsetTaskUrl();
      } else {
        setTaskUrl((String)value);
      }
      break;

    case HOST:
      if (value == null) {
        unsetHost();
      } else {
        setHost((String)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case TYPE:
      return getType();

    case DUPLICATE_URL:
      return getDuplicateUrl();

    case DONE_URL:
      return getDoneUrl();

    case STATISTIC_URL:
      return getStatisticUrl();

    case TASK_URL:
      return getTaskUrl();

    case HOST:
      return getHost();

    case PORT:
      return getPort();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case TYPE:
      return isSetType();
    case DUPLICATE_URL:
      return isSetDuplicateUrl();
    case DONE_URL:
      return isSetDoneUrl();
    case STATISTIC_URL:
      return isSetStatisticUrl();
    case TASK_URL:
      return isSetTaskUrl();
    case HOST:
      return isSetHost();
    case PORT:
      return isSetPort();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ConsumerConfig)
      return this.equals((ConsumerConfig)that);
    return false;
  }

  public boolean equals(ConsumerConfig that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_duplicateUrl = true && this.isSetDuplicateUrl();
    boolean that_present_duplicateUrl = true && that.isSetDuplicateUrl();
    if (this_present_duplicateUrl || that_present_duplicateUrl) {
      if (!(this_present_duplicateUrl && that_present_duplicateUrl))
        return false;
      if (!this.duplicateUrl.equals(that.duplicateUrl))
        return false;
    }

    boolean this_present_doneUrl = true && this.isSetDoneUrl();
    boolean that_present_doneUrl = true && that.isSetDoneUrl();
    if (this_present_doneUrl || that_present_doneUrl) {
      if (!(this_present_doneUrl && that_present_doneUrl))
        return false;
      if (!this.doneUrl.equals(that.doneUrl))
        return false;
    }

    boolean this_present_statisticUrl = true && this.isSetStatisticUrl();
    boolean that_present_statisticUrl = true && that.isSetStatisticUrl();
    if (this_present_statisticUrl || that_present_statisticUrl) {
      if (!(this_present_statisticUrl && that_present_statisticUrl))
        return false;
      if (!this.statisticUrl.equals(that.statisticUrl))
        return false;
    }

    boolean this_present_taskUrl = true && this.isSetTaskUrl();
    boolean that_present_taskUrl = true && that.isSetTaskUrl();
    if (this_present_taskUrl || that_present_taskUrl) {
      if (!(this_present_taskUrl && that_present_taskUrl))
        return false;
      if (!this.taskUrl.equals(that.taskUrl))
        return false;
    }

    boolean this_present_host = true && this.isSetHost();
    boolean that_present_host = true && that.isSetHost();
    if (this_present_host || that_present_host) {
      if (!(this_present_host && that_present_host))
        return false;
      if (!this.host.equals(that.host))
        return false;
    }

    boolean this_present_port = true && this.isSetPort();
    boolean that_present_port = true && that.isSetPort();
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_type = true && (isSetType());
    list.add(present_type);
    if (present_type)
      list.add(type);

    boolean present_duplicateUrl = true && (isSetDuplicateUrl());
    list.add(present_duplicateUrl);
    if (present_duplicateUrl)
      list.add(duplicateUrl);

    boolean present_doneUrl = true && (isSetDoneUrl());
    list.add(present_doneUrl);
    if (present_doneUrl)
      list.add(doneUrl);

    boolean present_statisticUrl = true && (isSetStatisticUrl());
    list.add(present_statisticUrl);
    if (present_statisticUrl)
      list.add(statisticUrl);

    boolean present_taskUrl = true && (isSetTaskUrl());
    list.add(present_taskUrl);
    if (present_taskUrl)
      list.add(taskUrl);

    boolean present_host = true && (isSetHost());
    list.add(present_host);
    if (present_host)
      list.add(host);

    boolean present_port = true && (isSetPort());
    list.add(present_port);
    if (present_port)
      list.add(port);

    return list.hashCode();
  }

  @Override
  public int compareTo(ConsumerConfig other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDuplicateUrl()).compareTo(other.isSetDuplicateUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDuplicateUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.duplicateUrl, other.duplicateUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDoneUrl()).compareTo(other.isSetDoneUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoneUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doneUrl, other.doneUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatisticUrl()).compareTo(other.isSetStatisticUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatisticUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.statisticUrl, other.statisticUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTaskUrl()).compareTo(other.isSetTaskUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskUrl, other.taskUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHost()).compareTo(other.isSetHost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host, other.host);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPort()).compareTo(other.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.port, other.port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ConsumerConfig(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (isSetDuplicateUrl()) {
      if (!first) sb.append(", ");
      sb.append("duplicateUrl:");
      if (this.duplicateUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.duplicateUrl);
      }
      first = false;
    }
    if (isSetDoneUrl()) {
      if (!first) sb.append(", ");
      sb.append("doneUrl:");
      if (this.doneUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.doneUrl);
      }
      first = false;
    }
    if (isSetStatisticUrl()) {
      if (!first) sb.append(", ");
      sb.append("statisticUrl:");
      if (this.statisticUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.statisticUrl);
      }
      first = false;
    }
    if (isSetTaskUrl()) {
      if (!first) sb.append(", ");
      sb.append("taskUrl:");
      if (this.taskUrl == null) {
        sb.append("null");
      } else {
        sb.append(this.taskUrl);
      }
      first = false;
    }
    if (isSetHost()) {
      if (!first) sb.append(", ");
      sb.append("host:");
      if (this.host == null) {
        sb.append("null");
      } else {
        sb.append(this.host);
      }
      first = false;
    }
    if (isSetPort()) {
      if (!first) sb.append(", ");
      sb.append("port:");
      sb.append(this.port);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    if (name == null) {
      throw new TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    if (type == null) {
      throw new TProtocolException("Required field 'type' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ConsumerConfigStandardSchemeFactory implements SchemeFactory {
    public ConsumerConfigStandardScheme getScheme() {
      return new ConsumerConfigStandardScheme();
    }
  }

  private static class ConsumerConfigStandardScheme extends StandardScheme<ConsumerConfig> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ConsumerConfig struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DUPLICATE_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.duplicateUrl = iprot.readString();
              struct.setDuplicateUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DONE_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.doneUrl = iprot.readString();
              struct.setDoneUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // STATISTIC_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.statisticUrl = iprot.readString();
              struct.setStatisticUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TASK_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskUrl = iprot.readString();
              struct.setTaskUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // HOST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.host = iprot.readString();
              struct.setHostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.port = iprot.readI32();
              struct.setPortIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ConsumerConfig struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeString(struct.type);
        oprot.writeFieldEnd();
      }
      if (struct.duplicateUrl != null) {
        if (struct.isSetDuplicateUrl()) {
          oprot.writeFieldBegin(DUPLICATE_URL_FIELD_DESC);
          oprot.writeString(struct.duplicateUrl);
          oprot.writeFieldEnd();
        }
      }
      if (struct.doneUrl != null) {
        if (struct.isSetDoneUrl()) {
          oprot.writeFieldBegin(DONE_URL_FIELD_DESC);
          oprot.writeString(struct.doneUrl);
          oprot.writeFieldEnd();
        }
      }
      if (struct.statisticUrl != null) {
        if (struct.isSetStatisticUrl()) {
          oprot.writeFieldBegin(STATISTIC_URL_FIELD_DESC);
          oprot.writeString(struct.statisticUrl);
          oprot.writeFieldEnd();
        }
      }
      if (struct.taskUrl != null) {
        if (struct.isSetTaskUrl()) {
          oprot.writeFieldBegin(TASK_URL_FIELD_DESC);
          oprot.writeString(struct.taskUrl);
          oprot.writeFieldEnd();
        }
      }
      if (struct.host != null) {
        if (struct.isSetHost()) {
          oprot.writeFieldBegin(HOST_FIELD_DESC);
          oprot.writeString(struct.host);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetPort()) {
        oprot.writeFieldBegin(PORT_FIELD_DESC);
        oprot.writeI32(struct.port);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ConsumerConfigTupleSchemeFactory implements SchemeFactory {
    public ConsumerConfigTupleScheme getScheme() {
      return new ConsumerConfigTupleScheme();
    }
  }

  private static class ConsumerConfigTupleScheme extends TupleScheme<ConsumerConfig> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ConsumerConfig struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.name);
      oprot.writeString(struct.type);
      BitSet optionals = new BitSet();
      if (struct.isSetDuplicateUrl()) {
        optionals.set(0);
      }
      if (struct.isSetDoneUrl()) {
        optionals.set(1);
      }
      if (struct.isSetStatisticUrl()) {
        optionals.set(2);
      }
      if (struct.isSetTaskUrl()) {
        optionals.set(3);
      }
      if (struct.isSetHost()) {
        optionals.set(4);
      }
      if (struct.isSetPort()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetDuplicateUrl()) {
        oprot.writeString(struct.duplicateUrl);
      }
      if (struct.isSetDoneUrl()) {
        oprot.writeString(struct.doneUrl);
      }
      if (struct.isSetStatisticUrl()) {
        oprot.writeString(struct.statisticUrl);
      }
      if (struct.isSetTaskUrl()) {
        oprot.writeString(struct.taskUrl);
      }
      if (struct.isSetHost()) {
        oprot.writeString(struct.host);
      }
      if (struct.isSetPort()) {
        oprot.writeI32(struct.port);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ConsumerConfig struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.name = iprot.readString();
      struct.setNameIsSet(true);
      struct.type = iprot.readString();
      struct.setTypeIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.duplicateUrl = iprot.readString();
        struct.setDuplicateUrlIsSet(true);
      }
      if (incoming.get(1)) {
        struct.doneUrl = iprot.readString();
        struct.setDoneUrlIsSet(true);
      }
      if (incoming.get(2)) {
        struct.statisticUrl = iprot.readString();
        struct.setStatisticUrlIsSet(true);
      }
      if (incoming.get(3)) {
        struct.taskUrl = iprot.readString();
        struct.setTaskUrlIsSet(true);
      }
      if (incoming.get(4)) {
        struct.host = iprot.readString();
        struct.setHostIsSet(true);
      }
      if (incoming.get(5)) {
        struct.port = iprot.readI32();
        struct.setPortIsSet(true);
      }
    }
  }

}
