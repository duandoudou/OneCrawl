/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.seveniu.thriftServer;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum Javascript implements TEnum {
  ON(1),
  OFF(2);

  private final int value;

  private Javascript(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Javascript findByValue(int value) { 
    switch (value) {
      case 1:
        return ON;
      case 2:
        return OFF;
      default:
        return null;
    }
  }
}
