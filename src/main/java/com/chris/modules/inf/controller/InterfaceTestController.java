package com.chris.modules.inf.controller;

import com.alibaba.fastjson.JSONObject;
import com.chris.common.utils.ResponseModel;
import com.chris.common.utils.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chris
 * @since Apr 20.18
 */
@RestController
@RequestMapping("/inf/test")
public class InterfaceTestController {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    /**
     * 列表
     */
    @RequestMapping("/query")
//    @RequiresPermissions(" res:resattachment:list")
    public ResponseModel query(@RequestBody JSONObject param){
        ResponseModel resp = restTemplateUtils.httpPostMediaTypeJson(restTemplateUtils.accessControlURL + "/passportStatistics/statisticsByCondition", ResponseModel.class, param);
        return resp;
    }
}
