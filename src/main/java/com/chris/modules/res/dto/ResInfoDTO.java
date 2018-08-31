package com.chris.modules.res.dto;

import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.res.entity.ResMaintenanceEntity;
import com.chris.modules.res.entity.ResPurchaseEntity;

public class ResInfoDTO {
    private ResBaseInfoEntity resBaseInfo;
    private ResPurchaseEntity resPurchase;
    private ResMaintenanceEntity resMaintenance;
    private ResInstallConfigEntity resInstallConfig;

    public ResBaseInfoEntity getResBaseInfo() {
        return resBaseInfo;
    }

    public void setResBaseInfo(ResBaseInfoEntity resBaseInfo) {
        this.resBaseInfo = resBaseInfo;
    }

    public ResPurchaseEntity getResPurchase() {
        return resPurchase;
    }

    public void setResPurchase(ResPurchaseEntity resPurchase) {
        this.resPurchase = resPurchase;
    }

    public ResMaintenanceEntity getResMaintenance() {
        return resMaintenance;
    }

    public void setResMaintenance(ResMaintenanceEntity resMaintenance) {
        this.resMaintenance = resMaintenance;
    }

    public ResInstallConfigEntity getResInstallConfig() {
        return resInstallConfig;
    }

    public void setResInstallConfig(ResInstallConfigEntity resInstallConfig) {
        this.resInstallConfig = resInstallConfig;
    }
}
