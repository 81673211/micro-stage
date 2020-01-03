package com.fred.microstage.service.user.feign.client;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import com.fred.microstage.service.user.feign.configuration.GoodsClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "micro-stage-service-goods"
        , configuration = GoodsClientConfiguration.class
)
public interface GoodsClient {

    /**
     * '@SpringQueryMap'可以用在消费端而服务端可以不必加@RequestBody
     */
    @PostMapping(value = "/find")
    String find(@SpringQueryMap GoodsFindRequest goodsFindRequest);
}
