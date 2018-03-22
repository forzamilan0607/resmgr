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

import com.chris.modules.res.entity.ResParamConfigEntity;
import com.chris.modules.res.service.ResParamConfigService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源参数配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/res/resparamconfig")
public class ResParamConfigController {
	@Autowired
	private ResParamConfigService resParamConfigService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions(" res:resparamconfig:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResParamConfigEntity> resParamConfigList = resParamConfigService.queryList(query);
		int total = resParamConfigService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resParamConfigList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{resId}")
	@RequiresPermissions(" res:resparamconfig:info")
	public R info(@PathVariable("resId") Long resId){
		ResParamConfigEntity resParamConfig = resParamConfigService.queryObject(resId);
		
		return R.ok().put("resParamConfig", resParamConfig);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions(" res:resparamconfig:save")
	public R save(@RequestBody ResParamConfigEntity resParamConfig){
		resParamConfigService.save(resParamConfig);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions(" res:resparamconfig:update")
	public R update(@RequestBody ResParamConfigEntity resParamConfig){
		resParamConfigService.update(resParamConfig);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions(" res:resparamconfig:delete")
	public R delete(@RequestBody Long[] resIds){
		resParamConfigService.deleteBatch(resIds);
		
		return R.ok();
	}
	
}
