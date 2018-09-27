package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysCompanyDao;
import com.chris.modules.sys.entity.SysCompanyEntity;
import com.chris.modules.sys.service.SysCompanyService;



@Service("sysCompanyService")
public class SysCompanyServiceImpl implements SysCompanyService {
	@Autowired
	private SysCompanyDao sysCompanyDao;
	
	@Override
	public SysCompanyEntity queryObject(Integer id){
		return sysCompanyDao.queryObject(id);
	}
	
	@Override
	public List<SysCompanyEntity> queryList(Map<String, Object> map){
		return sysCompanyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysCompanyDao.queryTotal(map);
	}
	
	@Override
	public void save(SysCompanyEntity sysCompany){
		sysCompanyDao.save(sysCompany);
	}
	
	@Override
	public void update(SysCompanyEntity sysCompany){
		sysCompanyDao.update(sysCompany);
	}
	
	@Override
	public void delete(Integer id){
		sysCompanyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysCompanyDao.deleteBatch(ids);
	}

	@Override
	public List<SysCompanyEntity> queryCompanyListByCondition(SysCompanyEntity param) {
		return this.sysCompanyDao.queryCompanyListByCondition(param);
	}
}
