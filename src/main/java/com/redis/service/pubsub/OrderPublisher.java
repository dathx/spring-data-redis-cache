package com.redis.service.pubsub;

import com.redis.config.RedisPubSubConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPublisher {
    private final StringRedisTemplate redisTemplate;

    public void publish(String message) {
        redisTemplate.convertAndSend(RedisPubSubConfig.TOPIC, message);
    }
}