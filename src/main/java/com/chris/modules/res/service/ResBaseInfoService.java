package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResBaseInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResBaseInfoService {
	
	ResBaseInfoEntity queryObject(Long id);
	
	List<ResBaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResBaseInfoEntity resBaseInfo);
	
	void update(ResBaseInfoEntity resBaseInfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

    void saveOtherObj(ResBaseInfoEntity resBaseInfo);

    ResBaseInfoEntity queryResBaseInfoById(Long id);
}
