package com.momincong.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenConfig {


    /**
     * 内存方式存放令牌
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
