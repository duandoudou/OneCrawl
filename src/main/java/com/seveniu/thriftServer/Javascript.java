/**
 * Autogenerated by Thrift Compiler (0.9.3)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.seveniu.thriftServer;


import org.apache.thrift.TEnum;

public enum Javascript implements TEnum {
    OFF(1),
    ON(2);

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
                return OFF;
            case 2:
                return ON;
            default:
                return null;
        }
    }
}
