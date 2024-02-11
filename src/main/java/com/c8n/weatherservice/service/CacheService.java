package com.c8n.weatherservice.service;

import com.c8n.weatherservice.model.entity.AuthUser;

import java.util.Optional;

public interface CacheService {
    AuthUser getUserByCacheKey(String key);
}
