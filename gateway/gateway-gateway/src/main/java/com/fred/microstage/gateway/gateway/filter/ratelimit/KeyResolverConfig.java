package com.fred.microstage.gateway.gateway.filter.ratelimit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 配置各种维度的限流
 */
@Configuration
public class KeyResolverConfig {

    /**
     * 根据用户参数限流
     */
    @Bean
    public UserKeyResolver userKeyResolver() {
        return new UserKeyResolver();
    }

    /**
     * 根据客户端ip地址限流
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    /**
     * 根据请求uri限流
     * @return
     */
    @Bean
    @Primary
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    private class UserKeyResolver implements KeyResolver {

        @Override
        public Mono<String> resolve(ServerWebExchange exchange) {
            return Mono.just(exchange.getRequest().getQueryParams().getFirst("name"));
        }
    }

    private class HostAddrKeyResolver implements KeyResolver {
        @Override
        public Mono<String> resolve(ServerWebExchange exchange) {
            return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        }
    }

    private class UriKeyResolver implements KeyResolver {
        @Override
        public Mono<String> resolve(ServerWebExchange exchange) {
            return Mono.just(exchange.getRequest().getURI().getPath());
        }
    }
}
