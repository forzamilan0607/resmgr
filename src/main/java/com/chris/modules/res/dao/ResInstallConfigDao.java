package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@Mapper
public interface ResInstallConfigDao extends BaseDao<ResInstallConfigEntity> {
	
}
