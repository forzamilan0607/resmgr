package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResInstallConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResInstallConfigService {
	
	ResInstallConfigEntity queryObject(Long id);
	
	List<ResInstallConfigEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResInstallConfigEntity resInstallConfig);
	
	void update(ResInstallConfigEntity resInstallConfig);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	ResInstallConfigEntity queryResInstallConfigByResId(Long resId);

	void deleteBatchByResIds(Long[] resIds);
}
