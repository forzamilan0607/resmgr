package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源类别
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResTypeService {
	
	ResTypeEntity queryObject(Integer id);
	
	List<ResTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResTypeEntity resType);
	
	void update(ResTypeEntity resType);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
