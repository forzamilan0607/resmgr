package com.chris.modules.generator.service;

import com.chris.modules.generator.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface SysDictService {
	
	SysDictEntity queryObject(Integer id);
	
	List<SysDictEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictEntity sysDict);
	
	void update(SysDictEntity sysDict);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
