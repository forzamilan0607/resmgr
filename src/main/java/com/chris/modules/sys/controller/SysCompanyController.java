package com.chris.modules.sys.controller;

import java.util.List;
import java.util.Map;

import com.chris.common.utils.CommonResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.modules.sys.entity.SysCompanyEntity;
import com.chris.modules.sys.service.SysCompanyService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 公司
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 24.18
 */
@RestController
@RequestMapping("/sys/syscompany")
public class SysCompanyController {
	@Autowired
	private SysCompanyService sysCompanyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/listAll")
	@RequiresPermissions("sys:syscompany:list")
	public CommonResponse listAll(@RequestBody SysCompanyEntity param){
		List<SysCompanyEntity> companyList = this.sysCompanyService.queryCompanyListByCondition(param);
		return CommonResponse.getSuccessResponse().setData(companyList);
	}

	@RequestMapping("/list")
	@RequiresPermissions("sys:syscompany:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysCompanyEntity> sysCompanyList = sysCompanyService.queryList(query);
		int total = sysCompanyService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(sysCompanyList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:syscompany:info")
	public R info(@PathVariable("id") Integer id){
		SysCompanyEntity sysCompany = sysCompanyService.queryObject(id);
		
		return R.ok().put("sysCompany", sysCompany);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:syscompany:save")
	public R save(@RequestBody SysCompanyEntity sysCompany){
		sysCompanyService.save(sysCompany);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:syscompany:update")
	public R update(@RequestBody SysCompanyEntity sysCompany){
		sysCompanyService.update(sysCompany);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:syscompany:delete")
	public R delete(@RequestBody Integer[] ids){
		sysCompanyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
