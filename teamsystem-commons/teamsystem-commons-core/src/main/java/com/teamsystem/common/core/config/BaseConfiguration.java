package com.teamsystem.common.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 核心commons的基础配置类
 * @author Moment
 */
@SuppressWarnings("SpringComponentScan")
@Configuration
@ComponentScan(basePackages = {"com.teamsystem.api"})
public class BaseConfiguration {

}
