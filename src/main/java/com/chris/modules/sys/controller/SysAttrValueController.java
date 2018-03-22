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

import com.chris.modules.sys.entity.SysAttrValueEntity;
import com.chris.modules.sys.service.SysAttrValueService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 属性值表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/sys/sysattrvalue")
public class SysAttrValueController {
	@Autowired
	private SysAttrValueService sysAttrValueService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysattrvalue:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysAttrValueEntity> sysAttrValueList = sysAttrValueService.queryList(query);
		int total = sysAttrValueService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysAttrValueList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{attrValueId}")
	@RequiresPermissions("sys:sysattrvalue:info")
	public R info(@PathVariable("attrValueId") Integer attrValueId){
		SysAttrValueEntity sysAttrValue = sysAttrValueService.queryObject(attrValueId);
		
		return R.ok().put("sysAttrValue", sysAttrValue);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysattrvalue:save")
	public R save(@RequestBody SysAttrValueEntity sysAttrValue){
		sysAttrValueService.save(sysAttrValue);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysattrvalue:update")
	public R update(@RequestBody SysAttrValueEntity sysAttrValue){
		sysAttrValueService.update(sysAttrValue);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysattrvalue:delete")
	public R delete(@RequestBody Integer[] attrValueIds){
		sysAttrValueService.deleteBatch(attrValueIds);
		
		return R.ok();
	}
	
}
