package com.teamsystem.common.mysql;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.teamsystem.data.base.BaseEntity;

/**
 * MybatisPlus 代码生成器
 *
 * @author Moment
 */
public class MBPGenerator {

    private static final String url = "jdbc:mysql://localhost:3306/teamsystem_cloud?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static final String userName = "root";
    private static final String password = "momincong";
    private static final String author = "Moment";
    private static final String outputDir = "";

    private static final String packageName = "com.teamsystem.common.mysql";
    private static final String moduleName = "";
    private static final String entityPackage = "entity";
    private static final String servicePackage = "service";
    private static final String serviceImplPackage = "service.impl";
    private static final String mapperPackage = "mapper";
    private static final String xmlPackage = "mapper.xml";
    private static final String controllerPackage = "controller";

    public static void main(String[] args) {
        FastAutoGenerator.create(url, userName, password)
                .globalConfig(builder -> {
                    builder.author(author)
                            //.outputDir(outputDir)
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(packageName)
                            .moduleName(moduleName)
                            .entity(entityPackage)
                            .service(servicePackage)
                            .serviceImpl(serviceImplPackage)
                            .mapper(mapperPackage)
                            .xml(xmlPackage)
                            .controller(controllerPackage);
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .superClass(BaseEntity.class)
                            .addSuperEntityColumns("revision", "create_time", "update_time", "del_flag");
                })
                .execute();
    }
}
