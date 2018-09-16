package com.chris.modules.oss.service;

import com.chris.modules.oss.entity.SysAttachmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 附件信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 16.18
 */
public interface SysAttachmentService {
	
	SysAttachmentEntity queryObject(Long id);
	
	List<SysAttachmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysAttachmentEntity sysAttachment);
	
	void update(SysAttachmentEntity sysAttachment);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
