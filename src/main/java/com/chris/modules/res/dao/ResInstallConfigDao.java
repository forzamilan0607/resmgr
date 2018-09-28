package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface ResInstallConfigDao extends BaseDao<ResInstallConfigEntity> {

    void save2His(Long resId);

    void deleteByResId(Long resId);
}
