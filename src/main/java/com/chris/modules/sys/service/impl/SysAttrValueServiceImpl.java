package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysAttrValueDao;
import com.chris.modules.sys.entity.SysAttrValueEntity;
import com.chris.modules.sys.service.SysAttrValueService;



@Service("sysAttrValueService")
public class SysAttrValueServiceImpl implements SysAttrValueService {
	@Autowired
	private SysAttrValueDao sysAttrValueDao;
	
	@Override
	public SysAttrValueEntity queryObject(Integer id){
		return sysAttrValueDao.queryObject(id);
	}
	
	@Override
	public List<SysAttrValueEntity> queryList(Map<String, Object> map){
		return sysAttrValueDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysAttrValueDao.queryTotal(map);
	}
	
	@Override
	public void save(SysAttrValueEntity sysAttrValue){
		sysAttrValueDao.save(sysAttrValue);
	}
	
	@Override
	public void update(SysAttrValueEntity sysAttrValue){
		sysAttrValueDao.update(sysAttrValue);
	}
	
	@Override
	public void delete(Integer id){
		sysAttrValueDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysAttrValueDao.deleteBatch(ids);
	}
	
}
