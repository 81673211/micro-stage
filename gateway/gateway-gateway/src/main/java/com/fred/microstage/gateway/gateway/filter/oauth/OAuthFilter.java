package com.fred.microstage.gateway.gateway.filter.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class OAuthFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisTemplate redisTemplate;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (pathMatcher.match("/oauth/callback", exchange.getRequest().getPath().value())) {
            return chain.filter(exchange);
        }
        String token = extractToken(exchange.getRequest());
        if (token == null) {
            final ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return null;
    }

    private String extractToken(ServerHttpRequest request) {
        final List<String> authorization = request.getHeaders().get("Authorization");
        String token = null;
        if (!CollectionUtils.isEmpty(authorization)) {
            token = authorization.get(0).substring("Bearer".length()).trim();
        }
        return token;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
