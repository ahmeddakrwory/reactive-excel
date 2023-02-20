package com.example.test.demo.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebMvcStompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableWebSocket
public class WebsocketConfigure implements WebSocketMessageBrokerConfigurer {
    StompEndpointRegistry registry;
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/reports");
        config.setApplicationDestinationPrefixes("/reports/*");
    }
//    @Override
    public void registerStompEndpoints() {
       this. registry.addEndpoint("/finsh");
       this. registry.addEndpoint("/finsh").withSockJS();
    }
}

