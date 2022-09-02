package com.shang.mybatisPlusDemo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusGenerator {

    /**
     * 详情见地址：https://mp.baomidou.com/guide/generator-new.html
     *
     * @param args
     */
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/zpark-changxin?useUnicode=true&characterEncoding=utf-8&useSSL=false&&serverTimezone=Asia/Shanghai",
                        "root", "111111")
                .globalConfig(builder -> {
                    builder.author("shang") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
//                            .dateType(DateType.ONLY_DATE)  // 时间格式 DateType.ONLY_DATE是Date类型，默认是LocalDateTime类型
                            .outputDir("D://generate"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.zxy.zpark.automat") // 设置父包名
//                            .moduleName("mybatis-plus-demo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://generate")) // 设置mapperXml生成路径
                            .serviceImpl("service") // 设置service实现类的包路径
                    ;
                })
                .templateConfig(config -> {
                    config.disable(TemplateType.SERVICE)  // 不需要service接口层
//                            .serviceImpl("/templates/controller.java")  // 设置模板，是复制在此项目resources目录下的路径
//                            .serviceImpl("/templates/serviceImpl.java")  // 设置模板，是复制在此项目resources目录下的路径
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_people_effect") // 设置需要生成的表名
                            .addTablePrefix("t_", "b_", "xj_") // 设置过滤表前缀
                            // entity配置
                            .entityBuilder()
                            .enableLombok()
                            .enableChainModel()
                            .enableActiveRecord()
                            .enableTableFieldAnnotation()
                            // controller配置
                            .controllerBuilder()
                            .enableRestStyle()
                            // service配置
                            .serviceBuilder()
                            .formatServiceImplFileName("%sService") // 设置Impl名称不带Impl（因为需要配置不生成service的接口类）
                            // mapper配置
                            .mapperBuilder()
                            .enableMapperAnnotation();
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
