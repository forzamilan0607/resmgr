package com.chris.modules.res.service.impl;

import com.chris.modules.res.dto.ResInfoDTO;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("resMgrService")
public class ResMgrServiceImpl implements ResMgrService {
    @Autowired
    private ResBaseInfoService resBaseInfoService;

    @Autowired
    private ResPurchaseService resPurchaseService;

    @Autowired
    private ResMaintenanceService resMaintenanceService;

    @Autowired
    private ResInstallConfigService resInstallConfigService;

    @Override
    public ResInfoDTO queryResInfoById(Long resId) {
        return null;
    }

    @Override
    public List<ResBaseInfoEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void saveResInfo(ResInfoDTO resInfoDTO) {
        this.resBaseInfoService.save(resInfoDTO.getResBaseInfo());
        this.resPurchaseService.save(resInfoDTO.getResPurchase());
        this.resMaintenanceService.save(resInfoDTO.getResMaintenance());
        this.resInstallConfigService.save(resInfoDTO.getResInstallConfig());
    }

    @Override
    public void updateResInfo(ResInfoDTO resInfoDTO) {

    }

    @Override
    public void deleteResInfoById(Long resId) {

    }

    @Override
    public void deleteBatchResInfo(Long[] resIds) {

    }
}
