package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysStaffEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 26.18
 */
@Mapper
public interface SysStaffDao extends BaseDao<SysStaffEntity> {
	
}
