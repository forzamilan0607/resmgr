package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDepartmentDao;
import com.chris.modules.sys.entity.SysDepartmentEntity;
import com.chris.modules.sys.service.SysDepartmentService;



@Service("sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {
	@Autowired
	private SysDepartmentDao sysDepartmentDao;
	
	@Override
	public SysDepartmentEntity queryObject(Integer deptId){
		return sysDepartmentDao.queryObject(deptId);
	}
	
	@Override
	public List<SysDepartmentEntity> queryList(Map<String, Object> map){
		return sysDepartmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDepartmentDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDepartmentEntity sysDepartment){
		sysDepartmentDao.save(sysDepartment);
	}
	
	@Override
	public void update(SysDepartmentEntity sysDepartment){
		sysDepartmentDao.update(sysDepartment);
	}
	
	@Override
	public void delete(Integer deptId){
		sysDepartmentDao.delete(deptId);
	}
	
	@Override
	public void deleteBatch(Integer[] deptIds){
		sysDepartmentDao.deleteBatch(deptIds);
	}
	
}