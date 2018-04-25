package com.chris.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chris.common.utils.CommonResponse;
import com.chris.common.utils.CommonUtils;
import com.chris.common.utils.ValidateUtils;
import com.chris.modules.sys.entity.SysDictItemEntity;
import com.chris.modules.sys.service.SysDictItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.dao.SysDictDao;
import com.chris.modules.sys.entity.SysDictEntity;
import com.chris.modules.sys.service.SysDictService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;


@Service("sysDictService")
@Slf4j
public class SysDictServiceImpl implements SysDictService {
	@Autowired
	private SysDictDao sysDictDao;
	@Autowired
	private SysDictItemService sysDictItemService;
	@Override
	public SysDictEntity queryObject(Integer dictId){
		SysDictEntity dataDict = this.sysDictDao.queryObject(dictId);
		if (!ObjectUtils.isEmpty(dataDict)) {
			dataDict.setDictItems(this.sysDictItemService.queryList(CommonUtils.buildMapByKeyValue(new String[]{"dictId"}, dictId)));
		}
		return dataDict;
	}
	
	@Override
	public List<SysDictEntity> queryList(Map<String, Object> map){
		return this.sysDictDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return this.sysDictDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(SysDictEntity sysDict){
		this.sysDictDao.save(sysDict);
		this.addDictItems(sysDict);
	}

	private void addDictItems(SysDictEntity sysDict) {
		this.setDictIdAndSort(sysDict);
		this.sysDictItemService.saveBatch(sysDict.getDictItems());
	}

	private void setDictIdAndSort(SysDictEntity sysDict) {
		for (int i = 0; i < sysDict.getDictItems().size(); i++) {
			SysDictItemEntity dictItem = sysDict.getDictItems().get(i);
			dictItem.setDictId(sysDict.getDictId());
			dictItem.setSortOrder(i + 1);
		}
	}

	@Override
	public void update(SysDictEntity sysDict){
		this.sysDictDao.update(sysDict);
		if (sysDict.isChangedDictItems()) {
			this.sysDictItemService.deleteByDictId(sysDict.getDictId());
			this.addDictItems(sysDict);
		}
	}
	
	@Override
	public void delete(Integer dictId){
		this.sysDictDao.delete(dictId);
	}
	
	@Override
	@Transactional
	public void deleteBatch(Integer[] dictIds){
		//删除字典前需要校验字典是否有引用
		this.sysDictDao.deleteBatch(dictIds);
		for (int i = 0; i < dictIds.length; i++) {
			this.sysDictItemService.deleteByDictId(dictIds[i]);
		}
	}

	/*public CommonResponse isCanDelete(Integer [] dictIds) {

	}*/

	@Override
	public List<SysDictEntity> querySysDictListByCondition(SysDictEntity param) {
		return this.sysDictDao.querySysDictListByCondition(param);
	}


}
