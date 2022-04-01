package com.teamsystem.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    //客户端信息服务
    private final ClientDetailsService clientDetailsService;
    //token存储策略
    private final TokenStore tokenStore;

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    /**
     * 配置令牌端点的安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                //读取令牌公钥接口不需要认证（/oauth/token_key）
                .tokenKeyAccess("permitAll()")
                //资源访问端点需要验证令牌时（即访问/oauth/check_token）需要先认证权限
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 配置令牌访问端点和令牌服务
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //用于密码模式
                .authenticationManager(authenticationManager)
                //用于授权码模式
                .authorizationCodeServices(authorizationCodeServices())
                //令牌管理服务
                .tokenServices(tokenServices())
                //使用POST来访问令牌
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    /**
     * 配置客户端信息验证
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //客户端名称
                .withClient("demoApp")
                //客户端密钥
                .secret(new BCryptPasswordEncoder().encode("passwordSecret"))
                //允许的授权方法
                .authorizedGrantTypes("password", "refresh_token","authorization_code","client_credentials","implicit")
                //授权范围
                .scopes("all")
                //资源列表
                .resourceIds("oauth2-resource")
                .redirectUris("https://momicong.com")
                //token过期时间
                .accessTokenValiditySeconds(12000)
                //refresh token过期时间
                .refreshTokenValiditySeconds(50000)
                //设置为false的时候第三方授权认证时跳转到授权页面
                .autoApprove(false);
    }


    /**
     * 配置令牌管理服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        //令牌有效期2小时
        services.setAccessTokenValiditySeconds(7200);
        //刷新令牌有效期3天
        services.setRefreshTokenValiditySeconds(259200);
        return services;
    }

}
