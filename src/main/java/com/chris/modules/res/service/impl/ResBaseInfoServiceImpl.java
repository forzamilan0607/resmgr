package com.chris.modules.res.service.impl;

import com.chris.common.utils.Constant;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;
import com.chris.modules.res.service.ResComponentService;
import com.chris.modules.res.service.ResEquipParamService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResBaseInfoDao;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.service.ResBaseInfoService;


@Slf4j
@Service("resBaseInfoService")
public class ResBaseInfoServiceImpl implements ResBaseInfoService {
	@Autowired
	private ResBaseInfoDao resBaseInfoDao;
	
	@Autowired
	private ResComponentService resComponentService;
	
	@Autowired
	private ResEquipParamService resEquipParamService;
	
	@Autowired
	private SysAttachmentService sysAttachmentService;
	
	@Override
	public ResBaseInfoEntity queryObject(Long id){
		return resBaseInfoDao.queryObject(id);
	}
	
	@Override
	public List<ResBaseInfoEntity> queryList(Map<String, Object> map){
		return resBaseInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resBaseInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(ResBaseInfoEntity resBaseInfo){
		resBaseInfoDao.save(resBaseInfo);
	}
	
	@Override
	public void update(ResBaseInfoEntity resBaseInfo){
		resBaseInfoDao.update(resBaseInfo);
		if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResComponentList())) {
			this.resComponentService.deleteByResId(resBaseInfo.getId());
			this.resComponentService.saveBatch(resBaseInfo.getResComponentList());
		}
		if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResEquipParamList())) {
			this.resEquipParamService.deleteByResId(resBaseInfo.getId());
			this.resEquipParamService.saveBatch(resBaseInfo.getResEquipParamList());
		}
		if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResNameplateAttachments())) {
			this.sysAttachmentService.updateBatch(resBaseInfo.getResNameplateAttachments());
		}
	}
	
	@Override
	public void delete(Long id){
		resBaseInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resBaseInfoDao.deleteBatch(ids);
	}

	@Override
	public void saveOtherObj(ResBaseInfoEntity resBaseInfo) {
		//保存设备主要部件信息
		if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResComponentList())) {
			this.resComponentService.saveBatch(resBaseInfo.getResComponentList());
		}
		//保存资源参数信息
		if (ValidateUtils.isNotEmptyCollection(resBaseInfo.getResEquipParamList())) {
			this.resEquipParamService.saveBatch(resBaseInfo.getResEquipParamList());
		}
		//更新资源铭牌信息
		this.sysAttachmentService.updateBatch(resBaseInfo.getResNameplateAttachments());
	}

	@Override
	public ResBaseInfoEntity queryResBaseInfoById(Long id) {
		ResBaseInfoEntity resBaseInfo = this.resBaseInfoDao.queryObject(id);
		if (ValidateUtils.isNotEmpty(resBaseInfo)) {
			resBaseInfo.setResComponentList(this.resComponentService.queryList(ImmutableMap.of("resId", resBaseInfo.getId())));
			resBaseInfo.setResEquipParamList(this.resEquipParamService.queryList(ImmutableMap.of("resId", resBaseInfo.getId())));
		} else {
			log.error("no data found by id[" + id + "]");
		}
		return resBaseInfo;
	}
}
