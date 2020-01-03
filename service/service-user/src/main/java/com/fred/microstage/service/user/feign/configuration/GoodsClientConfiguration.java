package com.fred.microstage.service.user.feign.configuration;

import feign.Request;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class GoodsClientConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(1000, 60000);
    }

    @Bean
    public Retryer feignRetry() {
        return new Retryer.Default();
    }
}
