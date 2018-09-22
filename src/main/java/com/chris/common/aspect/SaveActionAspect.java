package com.chris.common.aspect;

import com.chris.common.model.SysUpdateInfo;
import com.chris.common.utils.DateUtils;
import com.chris.common.utils.ShiroUtils;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.res.dto.ResInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SaveActionAspect {


    @Before("execution(* com.chris.modules.*.service.save*(..))")
    public void beforeSave(JoinPoint joinPoint) throws Throwable {
        if (ValidateUtils.isNotEmptyArray(joinPoint.getArgs())) {
            Object obj = joinPoint.getArgs()[0];
            if (obj instanceof ResInfoDTO) {
                ResInfoDTO resInfoDTO = (ResInfoDTO) obj;
                this.setUpdateInfoValue(resInfoDTO.getResBaseInfo());
                this.setUpdateInfoValue(resInfoDTO.getResPurchase());
                this.setUpdateInfoValue(resInfoDTO.getResMaintenance());
                this.setUpdateInfoValue(resInfoDTO.getResInstallConfig());
            }
            this.setUpdateInfoValue(obj);
        }
    }

    private void setUpdateInfoValue(Object obj) {
        if (ValidateUtils.isNotEmpty(obj) && obj instanceof SysUpdateInfo) {
            SysUpdateInfo updateInfo = (SysUpdateInfo) obj;
            updateInfo.setCreateTime(DateUtils.currentDate());
            updateInfo.setCreateUserId(Integer.valueOf(ShiroUtils.getUserId().toString()));
        }
    }
}
