package com.teamsystem.gateway.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * TODO
 *
 * @author Moment
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TokenConvertFilter implements GlobalFilter, Ordered {

    private final NimbusJwtDecoder jwtDecoder;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //判断是否是登录请求
        AntPathMatcher matcher = new AntPathMatcher();
        String path = exchange.getRequest().getPath().value();
        log.debug("path: "+path);
        if (matcher.match("/oauth/**", path)) {
            log.debug("match oauth2, pass");
            return chain.filter(exchange);
        }
        //获取token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        log.debug("token: "+token);
        //token为空
        if ("".equals(token) || token==null) return chain.filter(exchange);
        //解析token
        String realToken = token.replace("Bearer", "");
        Jwt decode = jwtDecoder.decode(realToken);
        log.debug("workId: " + decode.getClaim("user_name"));
        log.debug("authorities: " + decode.getClaim("authorities"));
        String authorities = decode.getClaim("authorities").toString();
        ServerHttpRequest request = exchange.getRequest().mutate()
                .headers(httpHeaders -> httpHeaders.remove("Authorization"))
                .header("workId", decode.getClaim("user_name").toString())
                .header("Authorities", authorities.substring(2, authorities.length() - 2)).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 99;
    }
}
