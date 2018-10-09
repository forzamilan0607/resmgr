package com.chris.modules.sys.controller;

import com.chris.common.model.CommonCheckParam;
import com.chris.common.utils.*;
import com.chris.common.validator.ValidatorUtils;
import com.chris.modules.sys.dao.BaseDao;
import com.chris.modules.sys.entity.SysAttrEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/commoncheck")
public class CommonCheckController {

    @RequestMapping("/checkName")
    public CommonResponse checkName(@RequestBody CommonCheckParam param){
        BaseDao baseDao = (BaseDao) SpringContextUtils.getBean(param.getDaoName());
        List resultList = baseDao.queryList(param.getCondition());
        return CommonResponse.getSuccessResponse().setData(resultList);
    }
}
