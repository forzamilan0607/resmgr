package com.chris;

import com.alibaba.fastjson.JSONObject;
import com.chris.modules.res.dto.ResInfoDTO;
import com.chris.modules.res.service.ResMgrService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectTest  {
    @Autowired
    private ResMgrService resMgrService;

    @Test
    public void queryResBaseInfo () {
        ResInfoDTO data = this.resMgrService.queryResInfoById(6L);
        System.out.println(JSONObject.toJSONString(data));
    }
}
