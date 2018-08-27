package com.chris.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.generator.dao.ResTypeDao;
import com.chris.modules.generator.entity.ResTypeEntity;
import com.chris.modules.generator.service.ResTypeService;



@Service("resTypeService")
public class ResTypeServiceImpl implements ResTypeService {
	@Autowired
	private ResTypeDao resTypeDao;
	
	@Override
	public ResTypeEntity queryObject(Integer id){
		return resTypeDao.queryObject(id);
	}
	
	@Override
	public List<ResTypeEntity> queryList(Map<String, Object> map){
		return resTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(ResTypeEntity resType){
		resTypeDao.save(resType);
	}
	
	@Override
	public void update(ResTypeEntity resType){
		resTypeDao.update(resType);
	}
	
	@Override
	public void delete(Integer id){
		resTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		resTypeDao.deleteBatch(ids);
	}
	
}
