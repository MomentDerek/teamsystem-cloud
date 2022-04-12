package com.teamsystem.common.mysql.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mysql公共配置类
 *
 * @author Moment
 */
@Configuration
@MapperScan("com.teamsystem.data.mapper")
public class MysqlAutoConfiguration {
}
