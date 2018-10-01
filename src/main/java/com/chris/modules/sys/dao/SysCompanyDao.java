package com.chris.modules.sys.dao;

import com.chris.modules.sys.entity.SysCompanyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 公司
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 24.18
 */
@Mapper
public interface SysCompanyDao extends BaseDao<SysCompanyEntity> {

    List<SysCompanyEntity> queryCompanyListByCondition(SysCompanyEntity param);
}
