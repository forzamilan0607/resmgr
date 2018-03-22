package com.chris.modules.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.modules.sys.entity.SysDictItemEntity;
import com.chris.modules.sys.service.SysDictItemService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/sys/sysdictitem")
public class SysDictItemController {
	@Autowired
	private SysDictItemService sysDictItemService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysdictitem:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysDictItemEntity> sysDictItemList = sysDictItemService.queryList(query);
		int total = sysDictItemService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDictItemList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{dictItemId}")
	@RequiresPermissions("sys:sysdictitem:info")
	public R info(@PathVariable("dictItemId") Integer dictItemId){
		SysDictItemEntity sysDictItem = sysDictItemService.queryObject(dictItemId);
		
		return R.ok().put("sysDictItem", sysDictItem);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysdictitem:save")
	public R save(@RequestBody SysDictItemEntity sysDictItem){
		sysDictItemService.save(sysDictItem);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysdictitem:update")
	public R update(@RequestBody SysDictItemEntity sysDictItem){
		sysDictItemService.update(sysDictItem);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysdictitem:delete")
	public R delete(@RequestBody Integer[] dictItemIds){
		sysDictItemService.deleteBatch(dictItemIds);
		
		return R.ok();
	}
	
}
