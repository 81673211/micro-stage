package com.fred.microstage.service.goods.controller;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/find")
    public String find(GoodsFindRequest goodsFindRequest) {
        return String.format("goods name : %s, welcome to micro-stage made by %s, server.port : %s",
                goodsFindRequest.getName(),
                goodsFindRequest.getUserId(), port);
    }
}
