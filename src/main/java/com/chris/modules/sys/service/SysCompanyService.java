package com.chris.modules.sys.service;

import com.chris.modules.sys.entity.SysCompanyEntity;

import java.util.List;
import java.util.Map;

/**
 * 公司
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 24.18
 */
public interface SysCompanyService {
	
	SysCompanyEntity queryObject(Integer id);
	
	List<SysCompanyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysCompanyEntity sysCompany);
	
	void update(SysCompanyEntity sysCompany);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    List<SysCompanyEntity> queryCompanyListByCondition(SysCompanyEntity param);
}
