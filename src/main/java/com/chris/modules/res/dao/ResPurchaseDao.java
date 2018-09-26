package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@Mapper
public interface ResPurchaseDao extends BaseDao<ResPurchaseEntity> {

}
