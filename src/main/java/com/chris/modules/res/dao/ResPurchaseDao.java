package com.chris.modules.res.dao;

import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@Mapper
public interface ResPurchaseDao extends BaseDao<ResPurchaseEntity> {
	
}