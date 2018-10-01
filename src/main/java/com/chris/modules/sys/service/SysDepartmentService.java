package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysDepartmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface SysDepartmentService {
	
	SysDepartmentEntity queryObject(Integer id);
	
	List<SysDepartmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

    List<SysDepartmentEntity> queryDepartmentListByCondition(SysDepartmentEntity param);

    void save(SysDepartmentEntity sysDepartment);
	
	void update(SysDepartmentEntity sysDepartment);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
