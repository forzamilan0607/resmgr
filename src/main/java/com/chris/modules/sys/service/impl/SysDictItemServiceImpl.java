package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDictItemDao;
import com.chris.modules.sys.entity.SysDictItemEntity;
import com.chris.modules.sys.service.SysDictItemService;



@Service("sysDictItemService")
public class SysDictItemServiceImpl implements SysDictItemService {
	@Autowired
	private SysDictItemDao sysDictItemDao;
	
	@Override
	public SysDictItemEntity queryObject(Integer dictItemId){
		return sysDictItemDao.queryObject(dictItemId);
	}
	
	@Override
	public List<SysDictItemEntity> queryList(Map<String, Object> map){
		return sysDictItemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDictItemDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDictItemEntity sysDictItem){
		sysDictItemDao.save(sysDictItem);
	}
	
	@Override
	public void update(SysDictItemEntity sysDictItem){
		sysDictItemDao.update(sysDictItem);
	}
	
	@Override
	public void delete(Integer dictItemId){
		sysDictItemDao.delete(dictItemId);
	}
	
	@Override
	public void deleteBatch(Integer[] dictItemIds){
		sysDictItemDao.deleteBatch(dictItemIds);
	}
	
}
