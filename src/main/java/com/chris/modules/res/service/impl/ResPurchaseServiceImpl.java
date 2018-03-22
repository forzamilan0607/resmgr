package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResPurchaseDao;
import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.res.service.ResPurchaseService;



@Service("resPurchaseService")
public class ResPurchaseServiceImpl implements ResPurchaseService {
	@Autowired
	private ResPurchaseDao resPurchaseDao;
	
	@Override
	public ResPurchaseEntity queryObject(Long purchaseId){
		return resPurchaseDao.queryObject(purchaseId);
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
	public void delete(Long purchaseId){
		resPurchaseDao.delete(purchaseId);
	}
	
	@Override
	public void deleteBatch(Long[] purchaseIds){
		resPurchaseDao.deleteBatch(purchaseIds);
	}
	
}
