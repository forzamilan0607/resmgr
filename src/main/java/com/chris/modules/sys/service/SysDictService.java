package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface SysDictService {
	
	SysDictEntity queryObject(Integer dictId);
	
	List<SysDictEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictEntity sysDict);
	
	void update(SysDictEntity sysDict);
	
	void delete(Integer dictId);
	
	void deleteBatch(Integer[] dictIds);
}
