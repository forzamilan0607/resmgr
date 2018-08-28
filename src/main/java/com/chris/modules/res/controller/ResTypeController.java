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

import com.chris.modules.res.entity.ResTypeEntity;
import com.chris.modules.res.service.ResTypeService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源类别
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/res/restype")
public class ResTypeController {
	@Autowired
	private ResTypeService resTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("res:restype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResTypeEntity> resTypeList = resTypeService.queryList(query);
		int total = resTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("res:restype:info")
	public R info(@PathVariable("id") Integer id){
		ResTypeEntity resType = resTypeService.queryObject(id);
		
		return R.ok().put("resType", resType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("res:restype:save")
	public R save(@RequestBody ResTypeEntity resType){
		resTypeService.save(resType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("res:restype:update")
	public R update(@RequestBody ResTypeEntity resType){
		resTypeService.update(resType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("res:restype:delete")
	public R delete(@RequestBody Integer[] ids){
		resTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
