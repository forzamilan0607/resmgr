package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDataDictDao;
import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.service.SysDataDictService;



@Service("sysDataDictService")
public class SysDataDictServiceImpl implements SysDataDictService {
	@Autowired
	private SysDataDictDao sysDataDictDao;
	
	@Override
	public SysDataDictEntity queryObject(Integer id){
		return sysDataDictDao.queryObject(id);
	}
	
	@Override
	public List<SysDataDictEntity> queryList(Map<String, Object> map){
		return sysDataDictDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDataDictDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDataDictEntity sysDataDict){
		sysDataDictDao.save(sysDataDict);
	}
	
	@Override
	public void update(SysDataDictEntity sysDataDict){
		sysDataDictDao.update(sysDataDict);
	}
	
	@Override
	public void delete(Integer id){
		sysDataDictDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysDataDictDao.deleteBatch(ids);
	}
	
}
