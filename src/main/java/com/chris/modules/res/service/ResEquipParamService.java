package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResEquipParamEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源设备参数信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
public interface ResEquipParamService {
	
	ResEquipParamEntity queryObject(Long id);
	
	List<ResEquipParamEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResEquipParamEntity resEquipParam);
	
	void update(ResEquipParamEntity resEquipParam);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void saveBatch(List<ResEquipParamEntity> resEquipParamList);

    void deleteByResId(Long resId);
}
