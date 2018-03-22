package com.chris.modules.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResAttachmentDao;
import com.chris.modules.res.entity.ResAttachmentEntity;
import com.chris.modules.res.service.ResAttachmentService;



@Service("resAttachmentService")
public class ResAttachmentServiceImpl implements ResAttachmentService {
	@Autowired
	private ResAttachmentDao resAttachmentDao;
	
	@Override
	public ResAttachmentEntity queryObject(Long attachId){
		return resAttachmentDao.queryObject(attachId);
	}
	
	@Override
	public List<ResAttachmentEntity> queryList(Map<String, Object> map){
		return resAttachmentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resAttachmentDao.queryTotal(map);
	}
	
	@Override
	public void save(ResAttachmentEntity resAttachment){
		resAttachmentDao.save(resAttachment);
	}
	
	@Override
	public void update(ResAttachmentEntity resAttachment){
		resAttachmentDao.update(resAttachment);
	}
	
	@Override
	public void delete(Long attachId){
		resAttachmentDao.delete(attachId);
	}
	
	@Override
	public void deleteBatch(Long[] attachIds){
		resAttachmentDao.deleteBatch(attachIds);
	}
	
}
