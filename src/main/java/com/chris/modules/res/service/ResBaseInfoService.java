package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResBaseInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface ResBaseInfoService {
	
	ResBaseInfoEntity queryObject(Long resId);
	
	List<ResBaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResBaseInfoEntity resBaseInfo);
	
	void update(ResBaseInfoEntity resBaseInfo);
	
	void delete(Long resId);
	
	void deleteBatch(Long[] resIds);
}
