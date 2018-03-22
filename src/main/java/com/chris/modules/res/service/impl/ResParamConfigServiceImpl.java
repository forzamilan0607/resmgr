package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResParamConfigDao;
import com.chris.modules.res.entity.ResParamConfigEntity;
import com.chris.modules.res.service.ResParamConfigService;



@Service("resParamConfigService")
public class ResParamConfigServiceImpl implements ResParamConfigService {
	@Autowired
	private ResParamConfigDao resParamConfigDao;
	
	@Override
	public ResParamConfigEntity queryObject(Long resId){
		return resParamConfigDao.queryObject(resId);
	}
	
	@Override
	public List<ResParamConfigEntity> queryList(Map<String, Object> map){
		return resParamConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resParamConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(ResParamConfigEntity resParamConfig){
		resParamConfigDao.save(resParamConfig);
	}
	
	@Override
	public void update(ResParamConfigEntity resParamConfig){
		resParamConfigDao.update(resParamConfig);
	}
	
	@Override
	public void delete(Long resId){
		resParamConfigDao.delete(resId);
	}
	
	@Override
	public void deleteBatch(Long[] resIds){
		resParamConfigDao.deleteBatch(resIds);
	}
	
}
