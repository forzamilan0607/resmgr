package com.chris.common.aspect;

import com.chris.common.model.SysUpdateInfo;
import com.chris.common.utils.DateUtils;
import com.chris.common.utils.ShiroUtils;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.res.dto.ResInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SaveActionAspect {

    private static final int ACTION_OTHER = 0;
    private static final int ACTION_SAVE = 1;
    private static final int ACTION_UPDATE = 2;

    //    @Before("execution(* com.chris.modules.*.service.impl.*(..))")
    @Before("execution(* com.chris.modules.*.service.*.*(..))")
    public void beforeSave(JoinPoint joinPoint) throws Throwable {
        if (ValidateUtils.isNotEmptyArray(joinPoint.getArgs())) {
            int actionType = ACTION_OTHER;
            if (this.isSaveAction(joinPoint.getSignature().getName())) {
                actionType = ACTION_SAVE;
            } else if (this.isUpdateAction(joinPoint.getSignature().getName())) {
                actionType =ACTION_UPDATE;
            }
            if (actionType != ACTION_OTHER) {
                Object obj = joinPoint.getArgs()[0];
                this.setUpdateInfoValue(obj, actionType);
            }
        }
    }

    private boolean isSaveAction(String methodName) {
        return methodName.startsWith("save") || methodName.startsWith("add") || methodName.startsWith("insert");
    }
    private boolean isUpdateAction(String methodName) {
        return methodName.startsWith("update") || methodName.startsWith("modify");
    }

    private void setUpdateInfoValue(Object obj, int actionType) {
        if (ValidateUtils.isNotEmpty(obj) && obj instanceof SysUpdateInfo) {
            SysUpdateInfo updateInfo = (SysUpdateInfo) obj;
            if (actionType == ACTION_SAVE) {
                updateInfo.setCreateTime(DateUtils.currentDate());
                updateInfo.setCreateUserId(Integer.valueOf(ShiroUtils.getUserId().toString()));
            } else if (actionType == ACTION_SAVE) {
                updateInfo.setUpdateTime(DateUtils.currentDate());
                updateInfo.setUpdateUserId(Integer.valueOf(ShiroUtils.getUserId().toString()));
            }
        }
    }
}
