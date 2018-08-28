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

import com.chris.modules.res.entity.ResPurchaseEntity;
import com.chris.modules.res.service.ResPurchaseService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源采购信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/res/respurchase")
public class ResPurchaseController {
	@Autowired
	private ResPurchaseService resPurchaseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("res:respurchase:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResPurchaseEntity> resPurchaseList = resPurchaseService.queryList(query);
		int total = resPurchaseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resPurchaseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("res:respurchase:info")
	public R info(@PathVariable("id") Long id){
		ResPurchaseEntity resPurchase = resPurchaseService.queryObject(id);
		
		return R.ok().put("resPurchase", resPurchase);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("res:respurchase:save")
	public R save(@RequestBody ResPurchaseEntity resPurchase){
		resPurchaseService.save(resPurchase);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("res:respurchase:update")
	public R update(@RequestBody ResPurchaseEntity resPurchase){
		resPurchaseService.update(resPurchase);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("res:respurchase:delete")
	public R delete(@RequestBody Long[] ids){
		resPurchaseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
