package com.server.auth.jwt;

/**
 * jwt 辅助类
 */
public class StringHelper {
    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
