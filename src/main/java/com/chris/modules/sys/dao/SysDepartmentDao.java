package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface SysDepartmentDao extends BaseDao<SysDepartmentEntity> {

    List<SysDepartmentEntity> queryDepartmentListByCondition(SysDepartmentEntity param);
}
