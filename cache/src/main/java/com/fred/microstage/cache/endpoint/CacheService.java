package com.fred.microstage.cache.endpoint;

import java.util.concurrent.TimeUnit;

public interface CacheService<K, V> {

    void set(K key, V value, long expire, TimeUnit timeUnit);

    V get(K key);

    boolean isExist(K key);
}
