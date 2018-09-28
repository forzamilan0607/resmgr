package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface ResBaseInfoDao extends BaseDao<ResBaseInfoEntity> {
	void save2His(ResBaseInfoEntity param);
}
