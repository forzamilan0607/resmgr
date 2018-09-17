package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysDataDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 18.18
 */
public interface SysDataDictService {
	
	SysDataDictEntity queryObject(Integer id);
	
	List<SysDataDictEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDataDictEntity sysDataDict);
	
	void update(SysDataDictEntity sysDataDict);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
