package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResBaseInfoDao;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.service.ResBaseInfoService;



@Service("resBaseInfoService")
public class ResBaseInfoServiceImpl implements ResBaseInfoService {
	@Autowired
	private ResBaseInfoDao resBaseInfoDao;
	
	@Override
	public ResBaseInfoEntity queryObject(Long resId){
		return resBaseInfoDao.queryObject(resId);
	}
	
	@Override
	public List<ResBaseInfoEntity> queryList(Map<String, Object> map){
		return resBaseInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resBaseInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ResBaseInfoEntity resBaseInfo){
		resBaseInfoDao.save(resBaseInfo);
	}
	
	@Override
	public void update(ResBaseInfoEntity resBaseInfo){
		resBaseInfoDao.update(resBaseInfo);
	}
	
	@Override
	public void delete(Long resId){
		resBaseInfoDao.delete(resId);
	}
	
	@Override
	public void deleteBatch(Long[] resIds){
		resBaseInfoDao.deleteBatch(resIds);
	}
	
}
