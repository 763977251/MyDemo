package com.shang.mybatisPlusDemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

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
                            .entityBuilder().enableLombok().enableTableFieldAnnotation()
                            .controllerBuilder().enableRestStyle()
                            .serviceBuilder()
                            .mapperBuilder().enableMapperAnnotation().enableBaseResultMap()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
