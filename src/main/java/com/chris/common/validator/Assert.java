package com.chris.common.validator;

import com.chris.common.exception.CommonException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CommonException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new CommonException(message);
        }
    }
}
