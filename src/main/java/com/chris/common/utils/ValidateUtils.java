package com.chris.common.utils;

import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @author chris
 * @since Apr 20.18
 */
public final class ValidateUtils {
    public static boolean isEmptyCollection(Collection c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNotEmptyCollection(Collection c) {
        return !isEmptyCollection(c);
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
    public static boolean isEmpty(Object obj) {
        return obj == null ? true : (obj.getClass().isArray() ? Array.getLength(obj) == 0 : (obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : (obj instanceof Collection ? ((Collection) obj).isEmpty() : (obj instanceof Map ? ((Map) obj).isEmpty() : false))));
    }

    public static boolean equals(Object o1, Object o2) {
        return ObjectUtils.nullSafeEquals(o1, o2);
    }
}
