package com.fred.microstage.service.goods.controller;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Value("${server.port}")
    private String port;

    /**
     * feign通信好jr多限制，参数多了不能用GET，还不能用GetMapping/PostMapping这类复合注解，参数名前还得加
     * '@RequestBody'/'@RequestParam' ...
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String find(@RequestBody GoodsFindRequest goodsFindRequest) {
        return String.format("goods name : %s, welcome to micro-stage made by %s, server.port : %s",
                goodsFindRequest.getName(),
                goodsFindRequest.getUserId(), port);
    }
}
