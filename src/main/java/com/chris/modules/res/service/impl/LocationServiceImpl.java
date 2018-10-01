package com.chris.modules.res.service.impl;

import com.chris.modules.res.dto.LocationParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.LocationDao;
import com.chris.modules.res.entity.LocationEntity;
import com.chris.modules.res.service.LocationService;



@Service("locationService")
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationDao locationDao;
	
	@Override
	public LocationEntity queryObject(Integer id){
		return locationDao.queryObject(id);
	}
	
	@Override
	public List<LocationEntity> queryList(Map<String, Object> map){
		return locationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return locationDao.queryTotal(map);
	}
	
	@Override
	public void save(LocationEntity location){
		locationDao.save(location);
	}
	
	@Override
	public void update(LocationEntity location){
		locationDao.update(location);
	}
	
	@Override
	public void delete(Integer id){
		locationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		locationDao.deleteBatch(ids);
	}

	@Override
	public List<LocationEntity> queryLocationListByCondition(LocationParamDTO param) {
		return this.locationDao.queryLocationListByCondition(param);
	}
}
