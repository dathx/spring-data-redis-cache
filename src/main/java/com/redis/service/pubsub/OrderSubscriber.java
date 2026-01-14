package com.redis.service.pubsub;

import org.springframework.stereotype.Component;

@Component
public class OrderSubscriber {
    public void onMessage(String message) {
        System.out.println("[SUB] Received: " + message);
    }
}