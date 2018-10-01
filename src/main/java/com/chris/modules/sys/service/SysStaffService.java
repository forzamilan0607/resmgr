package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysStaffEntity;

import java.util.List;
import java.util.Map;

/**
 * 员工信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 26.18
 */
public interface SysStaffService {
	
	SysStaffEntity queryObject(Integer id);
	
	List<SysStaffEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysStaffEntity sysStaff);
	
	void update(SysStaffEntity sysStaff);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
