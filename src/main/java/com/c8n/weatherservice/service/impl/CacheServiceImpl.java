package com.c8n.weatherservice.service.impl;

import com.c8n.weatherservice.model.entity.AuthUser;
import com.c8n.weatherservice.service.CacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {
    private final RedisTemplate<String, AuthUser> redisTemplate;

    public CacheServiceImpl(RedisTemplate<String, AuthUser> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public AuthUser getUserByCacheKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
