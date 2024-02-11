package com.c8n.weatherservice.config;

import com.c8n.weatherservice.model.api.WeatherResponse;
import com.c8n.weatherservice.model.entity.AuthUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${server_ip}")
    private String SERVER_IP;
    @Value("${redis_port}")
    private Integer REDIS_PORT;
    @Value("${redis_password}")
    private String REDIS_PASSWORD;

//    @Bean
//    public RedisStandaloneConfiguration redisStandaloneConfiguration(){
//        RedisStandaloneConfiguration redisStandaloneConfiguration =
//                new RedisStandaloneConfiguration(SERVER_IP, REDIS_PORT);
//        redisStandaloneConfiguration.setPassword(REDIS_PASSWORD);
//        return redisStandaloneConfiguration;
//    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory =
                new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(SERVER_IP);
        jedisConnectionFactory.setPort(REDIS_PORT);
        jedisConnectionFactory.setPassword(REDIS_PASSWORD);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, AuthUser> redisTemplate(){
        RedisTemplate<String, AuthUser> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(AuthUser.class));
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, WeatherResponse> weatherRedisTemplate(){
        RedisTemplate<String, WeatherResponse> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(WeatherResponse.class));
        return redisTemplate;
    }
}
