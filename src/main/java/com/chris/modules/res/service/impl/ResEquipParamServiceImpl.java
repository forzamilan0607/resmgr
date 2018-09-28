package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResEquipParamDao;
import com.chris.modules.res.entity.ResEquipParamEntity;
import com.chris.modules.res.service.ResEquipParamService;



@Service("resEquipParamService")
public class ResEquipParamServiceImpl implements ResEquipParamService {
	@Autowired
	private ResEquipParamDao resEquipParamDao;
	
	@Override
	public ResEquipParamEntity queryObject(Long id){
		return resEquipParamDao.queryObject(id);
	}
	
	@Override
	public List<ResEquipParamEntity> queryList(Map<String, Object> map){
		return resEquipParamDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resEquipParamDao.queryTotal(map);
	}
	
	@Override
	public void save(ResEquipParamEntity resEquipParam){
		resEquipParamDao.save(resEquipParam);
	}
	
	@Override
	public void update(ResEquipParamEntity resEquipParam){
		resEquipParamDao.update(resEquipParam);
	}
	
	@Override
	public void delete(Long id){
		resEquipParamDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resEquipParamDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<ResEquipParamEntity> resEquipParamList) {
		this.resEquipParamDao.saveBatch(resEquipParamList);
	}

	@Override
	public void deleteByResId(Long resId) {
		this.resEquipParamDao.save2His(resId);
		this.resEquipParamDao.deleteByResId(resId);
	}
}
