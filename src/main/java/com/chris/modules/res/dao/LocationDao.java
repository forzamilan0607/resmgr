package com.chris.modules.res.dao;

import com.chris.modules.res.dto.LocationParamDTO;
import com.chris.modules.res.entity.LocationEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 位置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 02.18
 */
@Mapper
public interface LocationDao extends BaseDao<LocationEntity> {

    List<LocationEntity> queryLocationListByCondition(LocationParamDTO param);
}
