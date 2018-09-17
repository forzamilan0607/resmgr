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

import com.chris.modules.sys.entity.SysDataDictEntity;
import com.chris.modules.sys.service.SysDataDictService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 数据字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 18.18
 */
@RestController
@RequestMapping("/sys/sysdatadict")
public class SysDataDictController {
	@Autowired
	private SysDataDictService sysDataDictService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysdatadict:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysDataDictEntity> sysDataDictList = sysDataDictService.queryList(query);
		int total = sysDataDictService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDataDictList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:sysdatadict:info")
	public R info(@PathVariable("id") Integer id){
		SysDataDictEntity sysDataDict = sysDataDictService.queryObject(id);
		
		return R.ok().put("sysDataDict", sysDataDict);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysdatadict:save")
	public R save(@RequestBody SysDataDictEntity sysDataDict){
		sysDataDictService.save(sysDataDict);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysdatadict:update")
	public R update(@RequestBody SysDataDictEntity sysDataDict){
		sysDataDictService.update(sysDataDict);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysdatadict:delete")
	public R delete(@RequestBody Integer[] ids){
		sysDataDictService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
