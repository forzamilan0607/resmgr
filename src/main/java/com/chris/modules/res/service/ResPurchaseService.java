package com.chris.modules.generator.service;

import com.chris.modules.generator.entity.ResPurchaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResPurchaseService {
	
	ResPurchaseEntity queryObject(Long id);
	
	List<ResPurchaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResPurchaseEntity resPurchase);
	
	void update(ResPurchaseEntity resPurchase);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
