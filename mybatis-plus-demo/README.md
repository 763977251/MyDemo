# mybatis-plus代码生产+分页插件
## 配置代码生成
```java
public class MybatisPlusGenerator {

    /**
     * 详情见地址：https://mp.baomidou.com/guide/generator-new.html
     * @param args
     */
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus_demo?useUnicode=true&characterEncoding=utf-8&useSSL=false&&serverTimezone=Asia/Shanghai",
                        "root", "111111")
                .globalConfig(builder -> {
                    builder.author("shang") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE)
                            .outputDir("D://generate"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.shang.mybatisPlusDemo") // 设置父包名
//                            .moduleName("mybatis-plus-demo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://generate")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("test_table") // 设置需要生成的表名
                            .addTablePrefix("t_", "b_") // 设置过滤表前缀
                            .entityBuilder().enableLombok().enableRemoveIsPrefix()
                            .controllerBuilder().enableRestStyle()
                            .serviceBuilder()
                            .mapperBuilder().enableMapperAnnotation().enableBaseResultMap()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
```

## 配置分页插件
```java
@Configuration
public class MybatisPlusConfig {
    /**
     * mybatis-plus的分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
```
### 简单测试分页
```java
@RestController
@RequestMapping("/test-table")
public class TestTableController {
    @Autowired
    protected ITestTableService testTableService;

    @GetMapping
    public Page<TestTable> test(){
        Page<TestTable> page = new Page<>();
        return testTableService.page(page);
    }
}
```
# 说明
- 具体信息见项目：https://github.com/763977251/MyDemo/tree/main/mybatis-plus-demo
- 执行resources下sql文件夹下的sql文件
- 配置数据库地址密码