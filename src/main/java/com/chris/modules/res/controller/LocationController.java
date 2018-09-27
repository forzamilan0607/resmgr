package com.chris.modules.res.controller;

import java.util.List;
import java.util.Map;

import com.chris.common.utils.*;
import com.chris.modules.res.dto.LocationParamDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.modules.res.entity.LocationEntity;
import com.chris.modules.res.service.LocationService;


/**
 * 位置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Sep 02.18
 */
@RestController
@RequestMapping("/res/location")
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("res:location:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<LocationEntity> locationList = locationService.queryList(query);
		int total = locationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(locationList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/queryLocationListByCondition")
	@RequiresPermissions("res:location:list")
	public CommonResponse queryLocationListByCondition(@RequestBody LocationParamDTO param){
	    if (StringUtils.isEmpty(param.getDeptId())) {
            param.setDeptId(ShiroUtils.getUserEntity().getDeptId());
        }
		List<LocationEntity> locationList = this.locationService.queryLocationListByCondition(param);
		return CommonResponse.getSuccessResponse().setData(locationList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("res:location:info")
	public R info(@PathVariable("id") Integer id){
		LocationEntity location = locationService.queryObject(id);
		
		return R.ok().put("location", location);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("res:location:save")
	public R save(@RequestBody LocationEntity location){
		locationService.save(location);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("res:location:update")
	public R update(@RequestBody LocationEntity location){
		locationService.update(location);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("res:location:delete")
	public R delete(@RequestBody Integer[] ids){
		locationService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
