package com.fred.microstage.service.user.service;

import com.fred.microstage.service.user.entity.User;
import com.fred.microstage.service.user.remote.GoodsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private GoodsClient goodsClient;

    public User get(Long id) {
        System.out.println(goodsClient.find(id));
        return null;
    }
}
