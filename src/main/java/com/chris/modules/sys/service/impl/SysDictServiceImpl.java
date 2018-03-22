package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDictDao;
import com.chris.modules.sys.entity.SysDictEntity;
import com.chris.modules.sys.service.SysDictService;



@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {
	@Autowired
	private SysDictDao sysDictDao;
	
	@Override
	public SysDictEntity queryObject(Integer dictId){
		return sysDictDao.queryObject(dictId);
	}
	
	@Override
	public List<SysDictEntity> queryList(Map<String, Object> map){
		return sysDictDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDictDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDictEntity sysDict){
		sysDictDao.save(sysDict);
	}
	
	@Override
	public void update(SysDictEntity sysDict){
		sysDictDao.update(sysDict);
	}
	
	@Override
	public void delete(Integer dictId){
		sysDictDao.delete(dictId);
	}
	
	@Override
	public void deleteBatch(Integer[] dictIds){
		sysDictDao.deleteBatch(dictIds);
	}
	
}
