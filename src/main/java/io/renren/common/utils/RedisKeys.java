package io.renren.common.utils;

/**
 * Redis所有Keys
 *
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
