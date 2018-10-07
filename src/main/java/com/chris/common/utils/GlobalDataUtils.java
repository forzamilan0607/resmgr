package com.chris.common.utils;

import com.chris.modules.sys.entity.SysConfigEntity;
import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.service.SysDataDictService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class GlobalDataUtils {
    private static ReentrantLock lock = new ReentrantLock();

    private static List<SysDataDictEntity> dataDictList;

    private static List<SysConfigEntity> configList;

    private GlobalDataUtils () {

    }

    public static List<SysDataDictEntity> getDataDictList() {
        if (ValidateUtils.isEmptyCollection(dataDictList)) {
            initQuerySysDataDicts();
        }
        return Collections.unmodifiableList(dataDictList);
    }

    public static List<SysConfigEntity> getConfigList() {
        if (ValidateUtils.isEmptyCollection(configList)) {
            initQuerySysConfigList();
        }
        return Collections.unmodifiableList(configList);
    }

    private static void initQuerySysConfigList() {
        lock.lock();
        try {
            CacheDataUtils cacheDataUtils = (CacheDataUtils) SpringContextUtils.getBean("cacheDataUtils");
            configList = cacheDataUtils.getConfigList();
        } finally {
            lock.unlock();
        }
    }

    private static void initQuerySysDataDicts() {
        lock.lock();
        try {
            CacheDataUtils cacheDataUtils = (CacheDataUtils) SpringContextUtils.getBean("cacheDataUtils");
            dataDictList = cacheDataUtils.getDataDictList();
        } finally {
            lock.unlock();
        }
    }

    public static void addDataDict(SysDataDictEntity sysDataDict) {
        lock.lock();
        try {
            dataDictList.add(sysDataDict);
        } finally {
            lock.unlock();
        }
    }

    public static void updateDataDict(SysDataDictEntity sysDataDict) {
        lock.lock();
        try {
            dataDictList.forEach(sysDataDictItem -> {
               if (ValidateUtils.equals(sysDataDictItem.getId(), sysDataDict.getId())) {
                   BeanUtils.copyProperties(sysDataDict, sysDataDictItem);
               }
            });
        } finally {
            lock.unlock();
        }
    }

    public static void deleteDataDictById(Long dataDictId) {
        lock.lock();
        try {
            dataDictList.removeIf(sysDataDictItem -> ValidateUtils.equals(sysDataDictItem.getId(), dataDictId));
        } finally {
            lock.unlock();
        }
    }



}
