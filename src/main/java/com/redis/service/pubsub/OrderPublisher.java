package com.redis.service.pubsub;

import com.redis.config.RedisPubSubConfig;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderPublisher {
    private final StringRedisTemplate redisTemplate;

    public void publish(String message) {
        redisTemplate.convertAndSend(RedisPubSubConfig.TOPIC, message);
    }
}