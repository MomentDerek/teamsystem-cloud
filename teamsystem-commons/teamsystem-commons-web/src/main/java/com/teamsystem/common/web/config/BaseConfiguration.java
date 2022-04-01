package com.teamsystem.common.web.config;

import com.teamsystem.common.web.exception.RestException;
import com.teamsystem.common.web.utils.ApplicationUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Web模块自动装配核心配置
 * @author Moment
 */
@Configuration
public class BaseConfiguration {

    /**
     * @return RestController层异常统一处理类
     */
    @Bean
    public RestException getRestException() {
        return new RestException();
    }

    /**
     * @return Spring容器工具类
     */
    @Bean
    public ApplicationUtils getApplicationUtils() {
        return new ApplicationUtils();
    }

}
