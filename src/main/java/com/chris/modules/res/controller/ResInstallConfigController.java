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

import com.chris.modules.res.entity.ResInstallConfigEntity;
import com.chris.modules.res.service.ResInstallConfigService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源安装/配置信息
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
@RestController
@RequestMapping("/res/resinstallconfig")
public class ResInstallConfigController {
	@Autowired
	private ResInstallConfigService resInstallConfigService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("res:resinstallconfig:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResInstallConfigEntity> resInstallConfigList = resInstallConfigService.queryList(query);
		int total = resInstallConfigService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resInstallConfigList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("res:resinstallconfig:info")
	public R info(@PathVariable("id") Long id){
		ResInstallConfigEntity resInstallConfig = resInstallConfigService.queryObject(id);
		
		return R.ok().put("resInstallConfig", resInstallConfig);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("res:resinstallconfig:save")
	public R save(@RequestBody ResInstallConfigEntity resInstallConfig){
		resInstallConfigService.save(resInstallConfig);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("res:resinstallconfig:update")
	public R update(@RequestBody ResInstallConfigEntity resInstallConfig){
		resInstallConfigService.update(resInstallConfig);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("res:resinstallconfig:delete")
	public R delete(@RequestBody Long[] ids){
		resInstallConfigService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
