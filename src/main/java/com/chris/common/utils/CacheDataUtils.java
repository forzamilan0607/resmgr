package com.chris.common.utils;

import com.chris.modules.sys.entity.SysConfigEntity;
import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.service.SysConfigService;
import com.chris.modules.sys.service.SysDataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component("cacheDataUtils")
public class CacheDataUtils {
    @Autowired
    private SysDataDictService sysDataDictService;

    @Autowired
    private SysConfigService sysConfigService;

    private List<SysDataDictEntity> dataDictList;

    private List<SysConfigEntity> configList;

    @PostConstruct
    public void init() {
        this.dataDictList = this.sysDataDictService.queryList(Collections.EMPTY_MAP);
        System.out.println("dataDictList size = " + dataDictList.size());
        this.configList = this.sysConfigService.queryAll();
        System.out.println("configList size = " + configList.size());
    }


    public List<SysDataDictEntity> getDataDictList() {
        return this.dataDictList;
    }

    public List<SysConfigEntity> getConfigList() {
        return configList;
    }
}
