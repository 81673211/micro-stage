package com.fred.microstage.service.user.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("micro-stage-service-goods")
public interface GoodsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    String find(Long userId);
}
