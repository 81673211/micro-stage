package com.fred.microstage.service.user.feign.client;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import com.fred.microstage.service.user.feign.configuration.GoodsClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "micro-stage-service-goods"
        , configuration = GoodsClientConfiguration.class
)
public interface GoodsClient {

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    String find(@RequestBody GoodsFindRequest goodsFindRequest);
}
