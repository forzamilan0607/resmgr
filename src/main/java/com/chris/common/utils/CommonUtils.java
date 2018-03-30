package com.chris.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chris
 * @since Mar 26.18
 */
public final class CommonUtils {
    public static Map<String, Object> buildMapByKeyValue(String [] keys, Object ... values) {
        Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            resultMap.put(keys[i], values[i]);
        }
        return resultMap;
    }
}
