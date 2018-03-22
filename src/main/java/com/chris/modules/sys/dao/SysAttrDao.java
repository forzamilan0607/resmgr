package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysAttrEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 属性表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@Mapper
public interface SysAttrDao extends BaseDao<SysAttrEntity> {
	
}
