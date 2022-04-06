package com.teamsystem.generator;

import com.teamsystem.generator.utils.FastGenerator;

/**
 * MybatisPlus 代码生成器
 *
 * @author Moment
 */
public class MBPGenerator {

    public static void main(String[] args) throws Exception {
        FastGenerator generator = FastGenerator.getFastGenerator()
                //.url("jdbc:mysql://localhost:3306/teamsystem_cloud?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .url("jdbc:mysql://localhost:3306/genshin_map_archive?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .userName("root")
                .password("momincong")
                .author("Moment")
                .outputDir("/generator")
                .outputDir("/genshin_generator")
                .commentDateFormat("yyyy-MM-dd hh:mm:ss");

        //generator.entityPackage("com.teamsystem.data.entity")
        //        .mapperPackage("com.teamsystem.data.mapper")
        //        .xmlPackage("xml")
        //        .apiPackageName("com.teamsystem.api")
        //        .apiModuleName("authtest")
        //        .servicePackageAfterApi("service.mbp")
        //        .serviceImplPackageAfterApi("service.mbp.impl")
        //        .build();
        generator.entityPackage("site.yuanshen.archive.model.entity")
                .mapperPackage("site.yuanshen.archive.mapper")
                .xmlPackage("xml")
                .apiPackageName("site.yuanshen")
                .apiModuleName("archive")
                .servicePackageAfterApi("service.mbp")
                .serviceImplPackageAfterApi("service.mbp.impl")
                .build();
    }
}
