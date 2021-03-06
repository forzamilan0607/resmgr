package com.chris.modules.res.controller;

import com.chris.common.annotation.SysLog;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;
import com.chris.modules.res.dto.ResInfoDTO;
import com.chris.modules.res.entity.ResBaseInfoEntity;
import com.chris.modules.res.service.ResBaseInfoService;
import com.chris.modules.res.service.ResMgrService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 资源维护管理
 *
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 29.18
 */
@RestController
@RequestMapping("/res/resmgr")
public class ResMgrController {
    @Autowired
    private ResBaseInfoService resBaseInfoService;

    @Autowired
    private ResMgrService resMgrService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("res:resmgr:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ResBaseInfoEntity> resBaseInfoList = resBaseInfoService.queryList(query);
        int total = resBaseInfoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(resBaseInfoList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("res:resmgr:info")
    public R info(@PathVariable("id") Long id) {
        ResInfoDTO resInfoDTO = resMgrService.queryResInfoById(id);
        return R.ok().put("resInfoDTO", resInfoDTO);
    }

    /**
     * 保存
     */
    @SysLog("添加资源设备")
    @RequestMapping("/save")
    @RequiresPermissions("res:resmgr:save")
    public R save(@RequestBody ResInfoDTO resInfoDTO) {
        this.resMgrService.saveResInfo(resInfoDTO);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改资源设备")
    @RequestMapping("/update")
    @RequiresPermissions("res:resmgr:update")
    public R update(@RequestBody ResInfoDTO resInfoDTO) {
        this.resMgrService.updateResInfo(resInfoDTO);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("批量删除资源设备")
    @RequestMapping("/delete")
    @RequiresPermissions("res:resmgr:delete")
    public R delete(@RequestBody Long[] ids) {
        this.resMgrService.deleteBatchResInfo(ids);
        return R.ok();
    }

}
