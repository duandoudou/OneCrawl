package com.seveniu.def;

/**
 * Created by seveniu on 5/24/16.
 * SystemError
 */
public class SystemError {
    public static final int IMAGE_BLOOMFILTER_DESERIALIZATION_ERROR = 401;

    public static void shutdown(int code) {
        System.exit(code);
    }
}
