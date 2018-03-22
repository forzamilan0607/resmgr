package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResInstallConfigDao;
import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.res.service.ResInstallConfigService;



@Service("resInstallConfigService")
public class ResInstallConfigServiceImpl implements ResInstallConfigService {
	@Autowired
	private ResInstallConfigDao resInstallConfigDao;
	
	@Override
	public ResInstallConfigEntity queryObject(Long configId){
		return resInstallConfigDao.queryObject(configId);
	}
	
	@Override
	public List<ResInstallConfigEntity> queryList(Map<String, Object> map){
		return resInstallConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resInstallConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(ResInstallConfigEntity resInstallConfig){
		resInstallConfigDao.save(resInstallConfig);
	}
	
	@Override
	public void update(ResInstallConfigEntity resInstallConfig){
		resInstallConfigDao.update(resInstallConfig);
	}
	
	@Override
	public void delete(Long configId){
		resInstallConfigDao.delete(configId);
	}
	
	@Override
	public void deleteBatch(Long[] configIds){
		resInstallConfigDao.deleteBatch(configIds);
	}
	
}
