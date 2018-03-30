package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysDictItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface SysDictItemService {
	
	SysDictItemEntity queryObject(Integer dictItemId);
	
	List<SysDictItemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDictItemEntity sysDictItem);

	void saveBatch(List<SysDictItemEntity> list);
	
	void update(SysDictItemEntity sysDictItem);
	
	void delete(Integer dictItemId);
	
	void deleteBatch(Integer[] dictItemIds);
}
