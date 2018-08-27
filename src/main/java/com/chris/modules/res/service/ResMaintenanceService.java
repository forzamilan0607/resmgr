package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResMaintenanceEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源运维信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResMaintenanceService {
	
	ResMaintenanceEntity queryObject(Long id);
	
	List<ResMaintenanceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResMaintenanceEntity resMaintenance);
	
	void update(ResMaintenanceEntity resMaintenance);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
