package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResComponentDao;
import com.chris.modules.res.entity.ResComponentEntity;
import com.chris.modules.res.service.ResComponentService;



@Service("resComponentService")
public class ResComponentServiceImpl implements ResComponentService {
	@Autowired
	private ResComponentDao resComponentDao;
	
	@Override
	public ResComponentEntity queryObject(Long id){
		return resComponentDao.queryObject(id);
	}
	
	@Override
	public List<ResComponentEntity> queryList(Map<String, Object> map){
		return resComponentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resComponentDao.queryTotal(map);
	}
	
	@Override
	public void save(ResComponentEntity resComponent){
		resComponentDao.save(resComponent);
	}
	
	@Override
	public void update(ResComponentEntity resComponent){
		resComponentDao.update(resComponent);
	}
	
	@Override
	public void delete(Long id){
		resComponentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resComponentDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<ResComponentEntity> resComponentList) {
		this.resComponentDao.saveBatch(resComponentList);
	}

	@Override
	public void deleteByResId(Long resId) {
		//首先入历史表
		this.resComponentDao.save2His(resId);
		this.resComponentDao.deleteByResId(resId);
	}
}
