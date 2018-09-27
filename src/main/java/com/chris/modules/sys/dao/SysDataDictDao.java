package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 18.18
 */
@Mapper
public interface SysDataDictDao extends BaseDao<SysDataDictEntity> {
	
}
