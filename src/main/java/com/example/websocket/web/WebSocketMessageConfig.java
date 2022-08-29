package com.example.websocket.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker //註解是宣告啟用STOMP協定,他是WebSocket的子協定來傳輸(message broker)消息,當註冊了之後控制器(Controller)就能使用@MessageMapping
public class WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) { //方法是我們註冊了一個節點,用來映射指定URL,方法內註冊一個STOMP的endpoint,並且指定使用SockJS協定

        registry.addEndpoint("/chat-example").withSockJS();
    }

    @Override
    public void configureMessageBroker(final  MessageBrokerRegistry registry) { //方法是配製訊息代理(Message broker)

        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
