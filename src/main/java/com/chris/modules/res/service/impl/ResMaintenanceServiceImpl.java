package com.chris.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.generator.dao.ResMaintenanceDao;
import com.chris.modules.generator.entity.ResMaintenanceEntity;
import com.chris.modules.generator.service.ResMaintenanceService;



@Service("resMaintenanceService")
public class ResMaintenanceServiceImpl implements ResMaintenanceService {
	@Autowired
	private ResMaintenanceDao resMaintenanceDao;
	
	@Override
	public ResMaintenanceEntity queryObject(Long id){
		return resMaintenanceDao.queryObject(id);
	}
	
	@Override
	public List<ResMaintenanceEntity> queryList(Map<String, Object> map){
		return resMaintenanceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resMaintenanceDao.queryTotal(map);
	}
	
	@Override
	public void save(ResMaintenanceEntity resMaintenance){
		resMaintenanceDao.save(resMaintenance);
	}
	
	@Override
	public void update(ResMaintenanceEntity resMaintenance){
		resMaintenanceDao.update(resMaintenance);
	}
	
	@Override
	public void delete(Long id){
		resMaintenanceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resMaintenanceDao.deleteBatch(ids);
	}
	
}
