package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResComponentEntity;

import java.util.List;
import java.util.Map;

/**
 * 设备部件信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
public interface ResComponentService {
	
	ResComponentEntity queryObject(Long id);
	
	List<ResComponentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResComponentEntity resComponent);
	
	void update(ResComponentEntity resComponent);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void saveBatch(List<ResComponentEntity> resComponentList);

	void deleteByResId(Long resId);
}
