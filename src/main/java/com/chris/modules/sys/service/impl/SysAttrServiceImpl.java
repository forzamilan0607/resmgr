package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysAttrDao;
import com.chris.modules.sys.entity.SysAttrEntity;
import com.chris.modules.sys.service.SysAttrService;



@Service("sysAttrService")
public class SysAttrServiceImpl implements SysAttrService {
	@Autowired
	private SysAttrDao sysAttrDao;
	
	@Override
	public SysAttrEntity queryObject(Integer id){
		return sysAttrDao.queryObject(id);
	}
	
	@Override
	public List<SysAttrEntity> queryList(Map<String, Object> map){
		return sysAttrDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysAttrDao.queryTotal(map);
	}
	
	@Override
	public void save(SysAttrEntity sysAttr){
		sysAttrDao.save(sysAttr);
	}
	
	@Override
	public void update(SysAttrEntity sysAttr){
		sysAttrDao.update(sysAttr);
	}
	
	@Override
	public void delete(Integer id){
		sysAttrDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysAttrDao.deleteBatch(ids);
	}
	
}
