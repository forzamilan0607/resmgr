package com.chris.modules.generator.service;

import com.chris.modules.generator.entity.ResAttachmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public interface ResAttachmentService {
	
	ResAttachmentEntity queryObject(Long id);
	
	List<ResAttachmentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResAttachmentEntity resAttachment);
	
	void update(ResAttachmentEntity resAttachment);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
