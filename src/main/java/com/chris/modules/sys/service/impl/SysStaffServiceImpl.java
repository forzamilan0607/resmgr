package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysStaffDao;
import com.chris.modules.sys.entity.SysStaffEntity;
import com.chris.modules.sys.service.SysStaffService;



@Service("sysStaffService")
public class SysStaffServiceImpl implements SysStaffService {
	@Autowired
	private SysStaffDao sysStaffDao;
	
	@Override
	public SysStaffEntity queryObject(Integer id){
		return sysStaffDao.queryObject(id);
	}
	
	@Override
	public List<SysStaffEntity> queryList(Map<String, Object> map){
		return sysStaffDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysStaffDao.queryTotal(map);
	}
	
	@Override
	public void save(SysStaffEntity sysStaff){
		sysStaffDao.save(sysStaff);
	}
	
	@Override
	public void update(SysStaffEntity sysStaff){
		sysStaffDao.update(sysStaff);
	}
	
	@Override
	public void delete(Integer id){
		sysStaffDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysStaffDao.deleteBatch(ids);
	}
	
}
