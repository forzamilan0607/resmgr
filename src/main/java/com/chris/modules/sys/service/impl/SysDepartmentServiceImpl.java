package com.chris.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.generator.dao.SysDepartmentDao;
import com.chris.modules.generator.entity.SysDepartmentEntity;
import com.chris.modules.generator.service.SysDepartmentService;



@Service("sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {
	@Autowired
	private SysDepartmentDao sysDepartmentDao;
	
	@Override
	public SysDepartmentEntity queryObject(Integer id){
		return sysDepartmentDao.queryObject(id);
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
	public void delete(Integer id){
		sysDepartmentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysDepartmentDao.deleteBatch(ids);
	}
	
}
