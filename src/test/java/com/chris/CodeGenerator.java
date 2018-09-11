package com.chris;

import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.chris.ProjectConstant.*;

/**
 * @author chris
 * @since Feb 06.18
 */
public class CodeGenerator {
    //JDBC配置，请修改为你项目的实际配置
    private static final String JDBC_URL = "jdbc:mysql://47.99.125.173:3306/resmgr";
    private static final String JDBC_USERNAME = "admin";
    private static final String JDBC_PASSWORD = "123456";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    private static final String PROJECT_PATH = System.getProperty("user.dir");//项目在硬盘上的基础路径
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";//模板位置

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径

    private static final String MODULE_NAME = "test";

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(getServicePackage());//生成的Service存放路径

    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(getServiceImplPackage());//生成的Service实现存放路径

    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(getControllerPackage());//生成的Controller存放路径

    private static final String AUTHOR = "chris";

    private static final String DATE = convertDate();

    public static void main(String[] args) {
        //输入表名和bean名称
        genCode(new String[]{"t_player"}, new String[]{"Player"});
    }

    private static String convertDate() {
        String [] months = "Jan,Feb,Mar,Apr,May,June,July,Aug,Sep,Oct,Nov,Dec".split(",");
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String year = dateStr.substring(2, 4);
        String day = dateStr.substring(8, 10);
        int month = Integer.valueOf(dateStr.substring(5, 7)) - 1;
        return months[month] + " " + day + "." + year;
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     * @param tableNames 数据表名称...
     */
    public static void genCode(String [] tableNames, String [] beanNames) {
        for (int i = 0; i < tableNames.length; i++) {
            genCodeByCustomModelName(tableNames[i], null == beanNames ? null : beanNames[i]);
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
     * @param tableName 数据表名称
     * @param beanName 自定义的 bean 名称
     */
    public static void genCodeByCustomModelName(String tableName, String beanName) {
        genModelAndMapper(tableName, beanName);
        genService(tableName, beanName);
        genController(tableName, beanName);
    }


    public static void genModelAndMapper(String tableName, String beanName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(getModelPackage());
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(getMapperPackage());
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (!StringUtils.isEmpty(beanName)) {
            tableConfiguration.setDomainObjectName(beanName);
        }
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(beanName)) beanName = tableNameConvertUpperCamel(tableName);
        System.out.println(beanName + ".java 生成成功");
        System.out.println(beanName + "Mapper.java 生成成功");
        System.out.println(beanName + "Mapper.xml 生成成功");
        changeDir(PROJECT_PATH + RESOURCES_PATH + "/mapper", beanName);
        modifyFileContent(PROJECT_PATH + JAVA_PATH + "/com/chris/modules/" + MODULE_NAME + "/dao/" + beanName + "Mapper.java");
    }

    private static void changeDir(String dir, String beanName) {
        String mapperFileName = dir + "/" + beanName + "Mapper.xml";
        File mapperFile = new File(mapperFileName);
        File tempDir = new File(dir);
        String tgtDir = dir + "/" + MODULE_NAME;
        File tgtFile = new File(tgtDir);
        if (!tgtFile.exists()) {
            tgtFile.mkdir();
        }
        if (mapperFile.renameTo(new File(tgtDir + "/" + mapperFile.getName()))) {
            System.out.println("重命名文件成功！");
            mapperFile.delete();
        } else {
            System.out.println("重命名文件失败！");
        }
    }

    private static void modifyFileContent(String fileName) {
//        modifyFileContent(fileName, "com.chris.common.core.Mapper", "com.chris.modules.sys.dao.BaseDao");
//        modifyFileContent(fileName, "extends Mapper", "extends BaseDao");
        modifyFileContent(fileName, new String[]{"com.chris.common.core.Mapper", "extends Mapper"}, new String[]{"com.chris.modules.sys.dao.BaseDao", "extends BaseDao"});
    }

    private static void modifyFileContent(String filePath, String [] oldStrs, String [] newStrs) {
        File file = new File(filePath);
        Long fileLength = file.length();
        byte[] fileContext = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(filePath);
            in.read(fileContext);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(fileContext);
        for (int i = 0; i < oldStrs.length; i++) {
            if (str.indexOf(oldStrs[i]) >= 0) {
                str = str.replace(oldStrs[i], newStrs[i]);
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
            out.write(str.toCharArray());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    private static boolean modifyFileContent2(String fileName, String oldStr, String newStr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(fileName, "rw");
            String line = null;
            long lastPoint = 0; //记住上一次的偏移量
            while ((line = raf.readLine()) != null) {
                final long ponit = raf.getFilePointer();
                if(line.contains(oldStr)){
                    String str = line.replace(oldStr, newStr);
                    raf.seek(lastPoint);
                    raf.writeBytes(str);
                }
                lastPoint = ponit;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void genService(String tableName, String beanName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(beanName) ? tableNameConvertUpperCamel(tableName) : beanName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", getBasePackage());

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
            System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName, String beanName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(beanName) ? tableNameConvertUpperCamel(tableName) : beanName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", getBasePackage());

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

            System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase();//兼容使用大写的表名
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    private static String getServiceImplPackage() {
        return SERVICE_IMPL_PACKAGE.replace("{module}", MODULE_NAME);
    }
    private static String getControllerPackage() {
        return CONTROLLER_PACKAGE.replace("{module}", MODULE_NAME);
    }

    private static String getServicePackage() {
        return SERVICE_PACKAGE.replace("{module}", MODULE_NAME);
    }

    private static String getMapperPackage() {
        return MAPPER_PACKAGE.replace("{module}", MODULE_NAME);
    }

    private static String getModelPackage() {
        return MODEL_PACKAGE.replace("{module}", MODULE_NAME);
    }

    private static String getBasePackage() {
        return BASE_PACKAGE.replace("{module}", MODULE_NAME);
    }
}
