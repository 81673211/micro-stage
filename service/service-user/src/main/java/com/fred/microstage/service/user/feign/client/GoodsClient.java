package com.fred.microstage.service.user.feign.client;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import com.fred.microstage.service.user.feign.configuration.GoodsClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "micro-stage-service-goods"
        , configuration = GoodsClientConfiguration.class
//        , fallback = Goods
)
public interface GoodsClient {

    /**
     * The OpenFeign @QueryMap annotation provides support for POJOs to be used as GET parameter maps.
     * Unfortunately, the default OpenFeign QueryMap annotation is incompatible with Spring because it lacks a value property.
     *
     * Spring Cloud OpenFeign provides an equivalent @SpringQueryMap annotation,
     * which is used to annotate a POJO or Map parameter as a query parameter map.
     */
    @GetMapping(value = "/find")
    String find(@SpringQueryMap GoodsFindRequest goodsFindRequest);
}
