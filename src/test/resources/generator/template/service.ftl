package ${basePackage}.service;

import ${basePackage}.entity.${modelNameUpperCamel};
import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @since ${date}.
 */
public interface ${modelNameUpperCamel}Service {

    ${modelNameUpperCamel} queryObjectById(Integer id);

    int queryTotal(Map<String, Object> param);

    List<${modelNameUpperCamel}> queryList(Map<String, Object> param);

    void save(${modelNameUpperCamel} param);

    void update(${modelNameUpperCamel} param);

    void deleteById(Integer id);
}
