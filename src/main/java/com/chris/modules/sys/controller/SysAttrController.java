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

import com.chris.modules.sys.entity.SysAttrEntity;
import com.chris.modules.sys.service.SysAttrService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 属性表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/generator/sysattr")
public class SysAttrController {
	@Autowired
	private SysAttrService sysAttrService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("generator:sysattr:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysAttrEntity> sysAttrList = sysAttrService.queryList(query);
		int total = sysAttrService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysAttrList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("generator:sysattr:info")
	public R info(@PathVariable("id") Integer id){
		SysAttrEntity sysAttr = sysAttrService.queryObject(id);
		
		return R.ok().put("sysAttr", sysAttr);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:sysattr:save")
	public R save(@RequestBody SysAttrEntity sysAttr){
		sysAttrService.save(sysAttr);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:sysattr:update")
	public R update(@RequestBody SysAttrEntity sysAttr){
		sysAttrService.update(sysAttr);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:sysattr:delete")
	public R delete(@RequestBody Integer[] ids){
		sysAttrService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
