package com.chris.modules.res.service;

import com.chris.modules.res.dto.ResInfoDTO;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 资源管理服务接口
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 31.18
 */
public interface ResMgrService {

	ResInfoDTO queryResInfoById(Long resId);
	
	List<ResBaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

	@Transactional
	void saveResInfo(ResInfoDTO resInfoDTO);

	@Transactional
	void updateResInfo(ResInfoDTO resInfoDTO);
	
	void deleteResInfoById(Long resId);
	
	void deleteBatchResInfo(Long[] resIds);
}
