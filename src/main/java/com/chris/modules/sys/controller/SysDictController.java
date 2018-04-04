package com.chris.modules.sys.controller;

import java.util.List;
import java.util.Map;

import com.chris.modules.sys.service.SysDictItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.chris.modules.sys.entity.SysDictEntity;
import com.chris.modules.sys.service.SysDictService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/sys/sysdict")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysdict:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysDictEntity> sysDictList = sysDictService.queryList(query);
		int total = sysDictService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDictList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{dictId}")
	@RequiresPermissions("sys:sysdict:info")
	public R info(@PathVariable("dictId") Integer dictId){
		SysDictEntity sysDict = sysDictService.queryObject(dictId);

		return R.ok().put("sysDict", sysDict);
	}

	/**
	 * 验证字典KEY是否存在
	 */
	@RequestMapping("/checkDictKey")
	@ResponseBody
	public boolean checkDictKey(String dictKey){
		List<SysDictEntity> sysDictList = this.sysDictService.querySysDictListByCondition(SysDictEntity.buildByDictKey(dictKey));
		return CollectionUtils.isEmpty(sysDictList);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysdict:save")
	public R save(@RequestBody SysDictEntity sysDict){
		sysDictService.save(sysDict);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysdict:update")
	public R update(@RequestBody SysDictEntity sysDict){
		sysDictService.update(sysDict);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysdict:delete")
	public R delete(@RequestBody Integer[] dictIds){
		sysDictService.deleteBatch(dictIds);
		
		return R.ok();
	}
	
}
