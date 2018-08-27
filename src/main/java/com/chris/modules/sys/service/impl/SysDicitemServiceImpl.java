package com.chris.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDicitemDao;
import com.chris.modules.sys.entity.SysDicitemEntity;
import com.chris.modules.sys.service.SysDicitemService;



@Service("sysDicitemService")
public class SysDicitemServiceImpl implements SysDicitemService {
	@Autowired
	private SysDicitemDao sysDicitemDao;
	
	@Override
	public SysDicitemEntity queryObject(Integer id){
		return sysDicitemDao.queryObject(id);
	}
	
	@Override
	public List<SysDicitemEntity> queryList(Map<String, Object> map){
		return sysDicitemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDicitemDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDicitemEntity sysDicitem){
		sysDicitemDao.save(sysDicitem);
	}
	
	@Override
	public void update(SysDicitemEntity sysDicitem){
		sysDicitemDao.update(sysDicitem);
	}
	
	@Override
	public void delete(Integer id){
		sysDicitemDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysDicitemDao.deleteBatch(ids);
	}
	
}
