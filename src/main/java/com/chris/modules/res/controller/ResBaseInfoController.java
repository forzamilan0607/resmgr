package com.chris.modules.res.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.modules.generator.entity.ResBaseInfoEntity;
import com.chris.modules.generator.service.ResBaseInfoService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源基本信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/generator/resbaseinfo")
public class ResBaseInfoController {
	@Autowired
	private ResBaseInfoService resBaseInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("generator:resbaseinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResBaseInfoEntity> resBaseInfoList = resBaseInfoService.queryList(query);
		int total = resBaseInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resBaseInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("generator:resbaseinfo:info")
	public R info(@PathVariable("id") Long id){
		ResBaseInfoEntity resBaseInfo = resBaseInfoService.queryObject(id);
		
		return R.ok().put("resBaseInfo", resBaseInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:resbaseinfo:save")
	public R save(@RequestBody ResBaseInfoEntity resBaseInfo){
		resBaseInfoService.save(resBaseInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:resbaseinfo:update")
	public R update(@RequestBody ResBaseInfoEntity resBaseInfo){
		resBaseInfoService.update(resBaseInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:resbaseinfo:delete")
	public R delete(@RequestBody Long[] ids){
		resBaseInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
