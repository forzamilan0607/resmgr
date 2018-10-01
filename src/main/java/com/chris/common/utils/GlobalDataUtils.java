package com.chris.common.utils;

import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.service.SysDataDictService;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class GlobalDataUtils {
    private static ReentrantLock lock = new ReentrantLock();

    private static List<SysDataDictEntity> dataDictList = new ArrayList<>();

    private GlobalDataUtils () {

    }

    public static List<SysDataDictEntity> getDataDictList() {
        if (ValidateUtils.isEmptyCollection(dataDictList)) {
            initQuerySysDataDicts();
        }
        return Collections.unmodifiableList(dataDictList);
    }

    private static void initQuerySysDataDicts() {
        lock.lock();
        try {
            SysDataDictService service = (SysDataDictService) SpringContextUtils.getBean("sysDataDictService");
            dataDictList.addAll(service.queryList(Collections.emptyMap()));
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
