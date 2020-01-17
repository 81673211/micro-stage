package com.fred.microstage.cache.redis;

import com.fred.microstage.cache.endpoint.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class RedisService implements CacheService<String, String> {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void set(String key, String value, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expire, timeUnit);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean isExist(String key) {
        final Optional<String> optional = Optional.ofNullable(redisTemplate.opsForValue().get(key));
        return optional.isPresent();
    }
}
