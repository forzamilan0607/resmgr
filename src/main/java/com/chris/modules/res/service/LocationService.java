package com.chris.modules.res.service;

import com.chris.modules.res.dto.LocationParamDTO;
import com.chris.modules.res.entity.LocationEntity;

import java.util.List;
import java.util.Map;

/**
 * 位置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 02.18
 */
public interface LocationService {
	
	LocationEntity queryObject(Integer id);
	
	List<LocationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LocationEntity location);
	
	void update(LocationEntity location);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    List<LocationEntity> queryLocationListByCondition(LocationParamDTO param);
}
