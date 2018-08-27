package com.chris.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.generator.dao.ResPurchaseDao;
import com.chris.modules.generator.entity.ResPurchaseEntity;
import com.chris.modules.generator.service.ResPurchaseService;



@Service("resPurchaseService")
public class ResPurchaseServiceImpl implements ResPurchaseService {
	@Autowired
	private ResPurchaseDao resPurchaseDao;
	
	@Override
	public ResPurchaseEntity queryObject(Long id){
		return resPurchaseDao.queryObject(id);
	}
	
	@Override
	public List<ResPurchaseEntity> queryList(Map<String, Object> map){
		return resPurchaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resPurchaseDao.queryTotal(map);
	}
	
	@Override
	public void save(ResPurchaseEntity resPurchase){
		resPurchaseDao.save(resPurchase);
	}
	
	@Override
	public void update(ResPurchaseEntity resPurchase){
		resPurchaseDao.update(resPurchase);
	}
	
	@Override
	public void delete(Long id){
		resPurchaseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resPurchaseDao.deleteBatch(ids);
	}
	
}
