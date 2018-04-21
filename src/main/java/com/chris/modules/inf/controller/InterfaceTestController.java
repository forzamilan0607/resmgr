package com.chris.modules.inf.controller;

import com.alibaba.fastjson.JSONObject;
import com.chris.common.utils.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    public JSONObject query(@RequestBody JSONObject param){
        String url = restTemplateUtils.accessControlURL + "/reformer/interface/remotecontrol/opendoor";
//        JSONObject resp = restTemplateUtils.httpPostMediaTypeJson(url, JSONObject.class, param);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("data", param.get("data"));
        JSONObject resp = this.restTemplateUtils.httpGetUrlVariable(url, JSONObject.class, paramMap);
        return resp;
    }
}
