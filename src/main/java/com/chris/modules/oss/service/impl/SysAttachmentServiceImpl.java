package com.chris.modules.oss.service.impl;

import com.chris.modules.oss.dao.SysAttachmentDao;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sysAttachmentService")
public class SysAttachmentServiceImpl implements SysAttachmentService {
	@Autowired
	private SysAttachmentDao sysAttachmentDao;
	
	@Override
	public SysAttachmentEntity queryObject(Long id){
		return sysAttachmentDao.queryObject(id);
	}
	
	@Override
	public List<SysAttachmentEntity> queryList(Map<String, Object> map){
		return sysAttachmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysAttachmentDao.queryTotal(map);
	}
	
	@Override
	public void save(SysAttachmentEntity sysAttachment){
		sysAttachmentDao.save(sysAttachment);
	}
	
	@Override
	public void update(SysAttachmentEntity sysAttachment){
		sysAttachmentDao.update(sysAttachment);
	}
	
	@Override
	public void delete(Long id){
		sysAttachmentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		sysAttachmentDao.deleteBatch(ids);
	}

	@Override
	public void updateBatch(List<SysAttachmentEntity> sysAttachments) {
		this.sysAttachmentDao.updateBatch(sysAttachments);
	}

	@Override
	public List<SysAttachmentEntity> queryAttachmentsByCondition(SysAttachmentEntity param) {
		return this.sysAttachmentDao.queryAttachmentsByCondition(param);
	}
}
