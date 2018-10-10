package com.chris.modules.sys.controller;

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

import com.chris.modules.sys.entity.SysDepartmentEntity;
import com.chris.modules.sys.service.SysDepartmentService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;

/**
 * 部门
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/sys/sysdepartment")
public class SysDepartmentController {
	@Autowired
	private SysDepartmentService sysDepartmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:sysdepartment:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysDepartmentEntity> sysDepartmentList = sysDepartmentService.queryList(query);
		int total = sysDepartmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDepartmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/listAll")
	@RequiresPermissions(value = {"sys:sysdepartment:list", "res:resmgr:save"},logical= Logical.OR)
	public CommonResponse listAll(@RequestBody SysDepartmentEntity param){
		List<SysDepartmentEntity> deptList = this.sysDepartmentService.queryDepartmentListByCondition(param);
		return CommonResponse.getSuccessResponse().setData(deptList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:sysdepartment:info")
	public R info(@PathVariable("id") Integer id){
		SysDepartmentEntity sysDepartment = sysDepartmentService.queryObject(id);
		
		return R.ok().put("sysDepartment", sysDepartment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:sysdepartment:save")
	public R save(@RequestBody SysDepartmentEntity sysDepartment){
		sysDepartmentService.save(sysDepartment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:sysdepartment:update")
	public R update(@RequestBody SysDepartmentEntity sysDepartment){
		sysDepartmentService.update(sysDepartment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:sysdepartment:delete")
	public R delete(@RequestBody Integer[] ids){
		sysDepartmentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
