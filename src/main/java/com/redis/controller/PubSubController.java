package com.redis.controller;

import com.redis.service.pubsub.OrderPublisher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubsub")
@AllArgsConstructor
public class PubSubController {
    private final OrderPublisher publisher;

    @PostMapping("/publish")
    public String publish(@RequestParam String msg) {
        publisher.publish(msg);
        return "Published: " + msg;
    }
}