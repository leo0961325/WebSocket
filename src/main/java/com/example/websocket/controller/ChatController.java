package com.example.websocket.controller;

import com.example.websocket.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ChatController {

    //@MessageMapping類似於@RequestMapping
    //Spring Boot執行時會掃描group內的@Configuration如果有@Enable...將會啟用該配置
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage){

        log.info("信息 :" + chatMessage.getContent());

        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage chatMessage ,
                               SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());

        log.info("新增用戶:"+ chatMessage.getSender());

        return chatMessage;
    }
}
