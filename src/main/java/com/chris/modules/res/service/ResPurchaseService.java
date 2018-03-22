package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResPurchaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface ResPurchaseService {
	
	ResPurchaseEntity queryObject(Long purchaseId);
	
	List<ResPurchaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResPurchaseEntity resPurchase);
	
	void update(ResPurchaseEntity resPurchase);
	
	void delete(Long purchaseId);
	
	void deleteBatch(Long[] purchaseIds);
}
