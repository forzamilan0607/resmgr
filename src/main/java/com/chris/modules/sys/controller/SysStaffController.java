package com.chris.modules.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chris.common.utils.CommonResponse;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.modules.sys.entity.SysStaffEntity;
import com.chris.modules.sys.service.SysStaffService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 员工信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 26.18
 */
@RestController
@RequestMapping("/sys/sysstaff")
public class SysStaffController {
	@Autowired
	private SysStaffService sysStaffService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/listAll")
	@RequiresPermissions("sys:sysstaff:list")
	public CommonResponse listAll(@RequestParam Map<String, Object> params){
       return CommonResponse.getSuccessResponse().setData(this.sysStaffService.queryList(new HashMap<>()));
	}

	@RequestMapping("/getStaffTree")
	@RequiresPermissions(value = {"sys:sysstaff:list", "res:resmgr:save"},logical= Logical.OR)
	public CommonResponse getStaffTree(@RequestParam Map<String, Object> params){
       return CommonResponse.getSuccessResponse().setData(this.sysStaffService.queryList(new HashMap<>()));
	}

	@RequestMapping("/list")
	@RequiresPermissions("sys:sysstaff:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysStaffEntity> sysStaffList = sysStaffService.queryList(query);
		int total = sysStaffService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(sysStaffList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:sysstaff:info")
	public R info(@PathVariable("id") Integer id){
		SysStaffEntity sysStaff = sysStaffService.queryObject(id);
		
		return R.ok().put("sysStaff", sysStaff);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysstaff:save")
	public R save(@RequestBody SysStaffEntity sysStaff){
		sysStaffService.save(sysStaff);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysstaff:update")
	public R update(@RequestBody SysStaffEntity sysStaff){
		sysStaffService.update(sysStaff);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysstaff:delete")
	public R delete(@RequestBody Integer[] ids){
		sysStaffService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
