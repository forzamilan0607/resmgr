package com.chris.modules.oss.cloud;

import com.chris.modules.sys.service.SysConfigService;
import com.chris.common.utils.ConfigConstant;
import com.chris.common.utils.Constant;
import com.chris.common.utils.SpringContextUtils;

import java.util.List;
import java.util.Map;

/**
 * 文件上传Factory
 * @author chris
 * @email 258321511@qq.com
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    private static CloudStorageConfig config;
    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
        //获取云存储配置信息
        config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);
    }

    public static CloudStorageService build(){
        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
