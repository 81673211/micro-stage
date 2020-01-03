package com.fred.microstage.service.user.service;

import com.fred.microstage.service.goods.request.GoodsFindRequest;
import com.fred.microstage.service.user.feign.client.GoodsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private GoodsClient goodsClient;

    public String findGood(Long id) {
        GoodsFindRequest goodsFindRequest = new GoodsFindRequest();
        goodsFindRequest.setUserId(id);
        return goodsClient.find(goodsFindRequest);
    }
}
