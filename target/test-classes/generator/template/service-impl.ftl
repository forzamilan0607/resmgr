package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ${author}
 * @since ${date}
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {
    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public ${modelNameUpperCamel} queryObjectById(Integer id) {
        return this.${modelNameLowerCamel}Mapper.queryObject(id);
    }

    @Override
    public int queryTotal(Map<String, Object> param) {
        return this.${modelNameLowerCamel}Mapper.queryTotal(param);
    }

    @Override
    public List<${modelNameUpperCamel}> queryList(Map<String, Object> param) {
        return this.${modelNameLowerCamel}Mapper.queryList(param);
    }

    public void save(${modelNameUpperCamel} param) {
        this.${modelNameLowerCamel}Mapper.save(param);
    }

    public void update(${modelNameUpperCamel} param) {
        this.${modelNameLowerCamel}Mapper.update(param);
    }

    public void deleteById(Integer id) {
        this.${modelNameLowerCamel}Mapper.delete(id);
    }

}
