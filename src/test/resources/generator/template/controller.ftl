package ${basePackage}.controller;

import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.chris.common.utils.PageUtils;
import com.chris.common.utils.Query;
import com.chris.common.utils.R;
import com.chris.common.annotation.SysLog;
import com.chris.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
* @author ${author}
* @since ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/list")
    //添加权限控制 @RequiresPermissions("sys:schedule:list")
    public R list(@RequestParam Map<String, Object> param){
        Query query = new Query(param);
        List<${modelNameUpperCamel}> jobList = ${modelNameLowerCamel}Service.queryList(query);
        int total = scheduleJobService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(jobList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @PostMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ${modelNameUpperCamel} obj = ${modelNameLowerCamel}Service.queryObjectById(id);

        return R.ok().put("obj", obj);
    }

    @SysLog("record log") //TODO 记录日志，可修改
    @PostMapping("/save")
    @RequiresPermissions("sys:schedule:save") //TODO 权限控制可修改
    public R save(@RequestBody ${modelNameUpperCamel} param){
        ValidatorUtils.validateEntity(param);
        ${modelNameLowerCamel}Service.save(param);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestBody ${modelNameUpperCamel} param){
        ValidatorUtils.validateEntity(param);
        ${modelNameLowerCamel}Service.update(param);
        return R.ok();
    }

    @PostMapping("/deleteById")
    public R delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return R.ok();
    }
}
