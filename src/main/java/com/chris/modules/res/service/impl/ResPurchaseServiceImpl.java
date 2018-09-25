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

import com.chris.modules.res.dao.ResPurchaseDao;
import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.res.service.ResPurchaseService;


@Slf4j
@Service("resPurchaseService")
public class ResPurchaseServiceImpl implements ResPurchaseService {
	@Autowired
	private ResPurchaseDao resPurchaseDao;

	@Autowired
	private SysAttachmentService sysAttachmentService;
	
	@Override
	public ResPurchaseEntity queryObject(Long id){
		return resPurchaseDao.queryObject(id);
	}
	
	@Override
	public List<ResPurchaseEntity> queryList(Map<String, Object> map){
		return resPurchaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resPurchaseDao.queryTotal(map);
	}
	
	@Override
	public void save(ResPurchaseEntity resPurchase){
		this.resPurchaseDao.save(resPurchase);
		this.updateAttachments(resPurchase);
	}
	
	@Override
	public void update(ResPurchaseEntity resPurchase){
		this.resPurchaseDao.update(resPurchase);
		this.updateAttachments(resPurchase);
	}

	private void updateAttachments(ResPurchaseEntity resPurchase) {
		if (ValidateUtils.isNotEmptyCollection(resPurchase.getContractAttachments())) {
			this.sysAttachmentService.updateBatch(resPurchase.getContractAttachments());
		}
	}

	@Override
	public void delete(Long id){
		resPurchaseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		resPurchaseDao.deleteBatch(ids);
	}

	@Override
	public ResPurchaseEntity queryResPurchaseByResId(Long resId) {
		List<ResPurchaseEntity> resPurchaseList = this.resPurchaseDao.queryList(ImmutableMap.of("resId", resId));
		if (ValidateUtils.isNotEmptyCollection(resPurchaseList)) {
			ResPurchaseEntity resPurchase = resPurchaseList.get(0);
			return resPurchase;
		}
		log.error("no data found by resId[" + resId + "]");
		return null;
	}
}
