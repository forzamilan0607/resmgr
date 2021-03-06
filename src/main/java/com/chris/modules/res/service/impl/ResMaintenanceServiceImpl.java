package com.chris.modules.res.service.impl;

import com.chris.common.utils.Constant;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.oss.entity.SysAttachmentEntity;
import com.chris.modules.oss.service.SysAttachmentService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.res.dao.ResMaintenanceDao;
import com.chris.modules.res.entity.ResMaintenanceEntity;
import com.chris.modules.res.service.ResMaintenanceService;


@Slf4j
@Service("resMaintenanceService")
public class ResMaintenanceServiceImpl implements ResMaintenanceService {
	@Autowired
	private ResMaintenanceDao resMaintenanceDao;

	@Autowired
	private SysAttachmentService sysAttachmentService;
	
	@Override
	public ResMaintenanceEntity queryObject(Long id){
		return resMaintenanceDao.queryObject(id);
	}
	
	@Override
	public List<ResMaintenanceEntity> queryList(Map<String, Object> map){
		return resMaintenanceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resMaintenanceDao.queryTotal(map);
	}
	
	@Override
	public void save(ResMaintenanceEntity resMaintenance){
		this.resMaintenanceDao.save(resMaintenance);
		this.batchUpdateAttachments(resMaintenance);
	}

	private void batchUpdateAttachments(ResMaintenanceEntity resMaintenance) {
		if (ValidateUtils.isNotEmptyCollection(resMaintenance.getMaintainContractAttachments())) {
			this.sysAttachmentService.updateBatch(resMaintenance.getMaintainContractAttachments());
		}
		if (ValidateUtils.isNotEmptyCollection(resMaintenance.getResInstructionsAttachments())) {
			this.sysAttachmentService.updateBatch(resMaintenance.getResInstructionsAttachments());
		}
		if (ValidateUtils.isNotEmptyCollection(resMaintenance.getPrecautionsAttachments())) {
			this.sysAttachmentService.updateBatch(resMaintenance.getPrecautionsAttachments());
		}
	}

	@Override
	public void update(ResMaintenanceEntity resMaintenance){
		this.resMaintenanceDao.update(resMaintenance);
		this.batchUpdateAttachments(resMaintenance);
	}
	
	@Override
	public void delete(Long id){
		resMaintenanceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resMaintenanceDao.deleteBatch(ids);
	}

	@Override
	public ResMaintenanceEntity queryResMaintenceByResId(Long resId) {
		List<ResMaintenanceEntity> resMaintenanceList = this.resMaintenanceDao.queryList(ImmutableMap.of("resId", resId));
		if (ValidateUtils.isNotEmptyCollection(resMaintenanceList)) {
			ResMaintenanceEntity resMaintenance = resMaintenanceList.get(0);
			return resMaintenance;
		}
		log.error("no data found by resId[" + resId + "]");
		return null;
	}

	@Override
	public void deleteBatchByResIds(Long[] resIds) {
		for (int i = 0; i < resIds.length; i++) {
			this.resMaintenanceDao.save2His(resIds[i]);
			this.resMaintenanceDao.deleteByResId(resIds[i]);
		}
	}
}
