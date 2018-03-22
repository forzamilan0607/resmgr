package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResInstallConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface ResInstallConfigService {
	
	ResInstallConfigEntity queryObject(Long configId);
	
	List<ResInstallConfigEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResInstallConfigEntity resInstallConfig);
	
	void update(ResInstallConfigEntity resInstallConfig);
	
	void delete(Long configId);
	
	void deleteBatch(Long[] configIds);
}
