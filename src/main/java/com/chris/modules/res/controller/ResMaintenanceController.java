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

import com.chris.modules.res.entity.ResMaintenanceEntity;
import com.chris.modules.res.service.ResMaintenanceService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源运维信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/res/resmaintenance")
public class ResMaintenanceController {
	@Autowired
	private ResMaintenanceService resMaintenanceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions(" res:resmaintenance:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResMaintenanceEntity> resMaintenanceList = resMaintenanceService.queryList(query);
		int total = resMaintenanceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resMaintenanceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions(" res:resmaintenance:info")
	public R info(@PathVariable("id") Long id){
		ResMaintenanceEntity resMaintenance = resMaintenanceService.queryObject(id);
		
		return R.ok().put("resMaintenance", resMaintenance);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions(" res:resmaintenance:save")
	public R save(@RequestBody ResMaintenanceEntity resMaintenance){
		resMaintenanceService.save(resMaintenance);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions(" res:resmaintenance:update")
	public R update(@RequestBody ResMaintenanceEntity resMaintenance){
		resMaintenanceService.update(resMaintenance);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions(" res:resmaintenance:delete")
	public R delete(@RequestBody Long[] ids){
		resMaintenanceService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
