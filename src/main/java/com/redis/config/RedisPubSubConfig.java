package com.redis.config;

import com.redis.service.pubsub.OrderSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisPubSubConfig {

    public static final String TOPIC = "order-channel";

    @Bean
    public ChannelTopic orderTopic() {
        return new ChannelTopic(TOPIC);
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(OrderSubscriber subscriber) {
        // map message -> subscriber.onMessage(String)
        return new MessageListenerAdapter(subscriber, "onMessage");
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(
            RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter,
            ChannelTopic orderTopic
    ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, orderTopic);
        return container;
    }
}
