package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResEquipParamEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源设备参数信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 22.18
 */
@Mapper
public interface ResEquipParamDao extends BaseDao<ResEquipParamEntity> {

    void deleteByResId(Long resId);

    void save2His(Long resId);
}
