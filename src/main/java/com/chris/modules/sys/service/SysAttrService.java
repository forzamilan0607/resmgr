package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysAttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface SysAttrService {
	
	SysAttrEntity queryObject(Integer id);
	
	List<SysAttrEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysAttrEntity sysAttr);
	
	void update(SysAttrEntity sysAttr);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
