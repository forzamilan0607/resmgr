package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResComponentEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备部件信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
@Mapper
public interface ResComponentDao extends BaseDao<ResComponentEntity> {

    void deleteByResId(Long resId);
}
