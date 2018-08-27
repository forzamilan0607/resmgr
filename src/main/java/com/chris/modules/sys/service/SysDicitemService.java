package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysDicitemEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典项表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface SysDicitemService {
	
	SysDicitemEntity queryObject(Integer id);
	
	List<SysDicitemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDicitemEntity sysDicitem);
	
	void update(SysDicitemEntity sysDicitem);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
