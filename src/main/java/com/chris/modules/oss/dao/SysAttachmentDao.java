package com.chris.modules.oss.dao;

import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 附件信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 16.18
 */
@Mapper
public interface SysAttachmentDao extends BaseDao<SysAttachmentEntity> {

    void updateBatch(List<SysAttachmentEntity> sysAttachments);
}
