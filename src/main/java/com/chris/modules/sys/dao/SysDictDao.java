package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典表
 *
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface SysDictDao extends BaseDao<SysDictEntity> {

    List<SysDictEntity> querySysDictListByCondition(SysDictEntity param);
}
