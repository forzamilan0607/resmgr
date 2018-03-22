package com.chris.modules.res.service;

import com.chris.modules.res.entity.ResAttachmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public interface ResAttachmentService {
	
	ResAttachmentEntity queryObject(Long attachId);
	
	List<ResAttachmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResAttachmentEntity resAttachment);
	
	void update(ResAttachmentEntity resAttachment);
	
	void delete(Long attachId);
	
	void deleteBatch(Long[] attachIds);
}
