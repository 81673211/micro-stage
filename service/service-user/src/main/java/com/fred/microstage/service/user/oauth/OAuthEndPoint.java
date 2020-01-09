package com.fred.microstage.service.user.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthEndPoint {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/callback")
    public String callback(String code) {
        final OAuthToken authToken = tokenService.getToken(code);

        return "success";
    }
}
