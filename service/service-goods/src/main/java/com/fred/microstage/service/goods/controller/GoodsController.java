package com.fred.microstage.service.goods.controller;

import com.fred.microstage.service.goods.controller.request.GoodsFindRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/find")
    public String find(@RequestParam GoodsFindRequest request) {
        return String.format("goods name : %s, welcome to micro-stage made by %s, server.port : %s", request.getName(),
                request.getUserId(), port);
    }
}
