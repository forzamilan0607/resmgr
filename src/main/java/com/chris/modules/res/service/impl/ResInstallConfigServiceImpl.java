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

import com.chris.modules.res.dao.ResInstallConfigDao;
import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.res.service.ResInstallConfigService;


@Slf4j
@Service("resInstallConfigService")
public class ResInstallConfigServiceImpl implements ResInstallConfigService {
	@Autowired
	private ResInstallConfigDao resInstallConfigDao;

	@Autowired
	private SysAttachmentService sysAttachmentService;
	
	@Override
	public ResInstallConfigEntity queryObject(Long id){
		return resInstallConfigDao.queryObject(id);
	}
	
	@Override
	public List<ResInstallConfigEntity> queryList(Map<String, Object> map){
		return resInstallConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resInstallConfigDao.queryTotal(map);
	}
	
	@Override
	public void save(ResInstallConfigEntity resInstallConfig){
		this.resInstallConfigDao.save(resInstallConfig);
		this.updateAttachments(resInstallConfig);
	}

	private void updateAttachments(ResInstallConfigEntity resInstallConfig) {
		if (ValidateUtils.isNotEmptyCollection(resInstallConfig.getDrawingAttachments())) {
			this.sysAttachmentService.updateBatch(resInstallConfig.getDrawingAttachments());
		}
		if (ValidateUtils.isNotEmptyCollection(resInstallConfig.getOperSpecAttachments())) {
			this.sysAttachmentService.updateBatch(resInstallConfig.getOperSpecAttachments());
		}
	}

	@Override
	public void update(ResInstallConfigEntity resInstallConfig){
		this.resInstallConfigDao.update(resInstallConfig);
		this.updateAttachments(resInstallConfig);
	}
	
	@Override
	public void delete(Long id){
		resInstallConfigDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resInstallConfigDao.deleteBatch(ids);
	}

	@Override
	public ResInstallConfigEntity queryResInstallConfigByResId(Long resId) {
		List<ResInstallConfigEntity> resInstallConfigList = this.resInstallConfigDao.queryList(ImmutableMap.of("resId", resId));
		if (ValidateUtils.isNotEmptyCollection(resInstallConfigList)) {
			ResInstallConfigEntity resInstallConfig = resInstallConfigList.get(0);
			return resInstallConfig;
		}
		log.error("no data found by resId[" + resId + "]");
		return null;
	}

	@Override
	public void deleteBatchByResIds(Long[] resIds) {
		for (int i = 0; i < resIds.length; i++) {
			this.resInstallConfigDao.save2His(resIds[i]);
			this.resInstallConfigDao.deleteByResId(resIds[i]);
		}
	}
}
