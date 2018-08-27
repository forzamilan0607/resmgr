package com.chris.modules.res.dao;

import com.chris.modules.generator.entity.SysAttrValueEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 属性值表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface SysAttrValueDao extends BaseDao<SysAttrValueEntity> {
	
}
