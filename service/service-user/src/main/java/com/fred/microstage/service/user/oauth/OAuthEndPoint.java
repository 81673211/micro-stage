package com.fred.microstage.service.user.oauth;

import com.fred.microstage.cache.CacheConst;
import com.fred.microstage.cache.redis.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/oauth")
public class OAuthEndPoint {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/callback")
    public String callback(String code) {
        final OAuthToken authToken = tokenService.getToken(code);
        redisService.set(CacheConst.CACHE_OAUTH_TOKEN + authToken.getAccessToken(), StringUtils.EMPTY, 300, TimeUnit.SECONDS);
        return "success:" + authToken.getAccessToken();
    }
}
