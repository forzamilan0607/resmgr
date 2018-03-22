package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResParamConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源参数配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface ResParamConfigService {
	
	ResParamConfigEntity queryObject(Long resId);
	
	List<ResParamConfigEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResParamConfigEntity resParamConfig);
	
	void update(ResParamConfigEntity resParamConfig);
	
	void delete(Long resId);
	
	void deleteBatch(Long[] resIds);
}
