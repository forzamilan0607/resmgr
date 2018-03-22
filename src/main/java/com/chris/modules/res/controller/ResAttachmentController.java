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

import com.chris.modules.res.entity.ResAttachmentEntity;
import com.chris.modules.res.service.ResAttachmentService;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;




/**
 * 资源附件
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
@RestController
@RequestMapping("/res/resattachment")
public class ResAttachmentController {
	@Autowired
	private ResAttachmentService resAttachmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions(" res:resattachment:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ResAttachmentEntity> resAttachmentList = resAttachmentService.queryList(query);
		int total = resAttachmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(resAttachmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{attachId}")
	@RequiresPermissions(" res:resattachment:info")
	public R info(@PathVariable("attachId") Long attachId){
		ResAttachmentEntity resAttachment = resAttachmentService.queryObject(attachId);
		
		return R.ok().put("resAttachment", resAttachment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions(" res:resattachment:save")
	public R save(@RequestBody ResAttachmentEntity resAttachment){
		resAttachmentService.save(resAttachment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions(" res:resattachment:update")
	public R update(@RequestBody ResAttachmentEntity resAttachment){
		resAttachmentService.update(resAttachment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions(" res:resattachment:delete")
	public R delete(@RequestBody Long[] attachIds){
		resAttachmentService.deleteBatch(attachIds);
		
		return R.ok();
	}
	
}
