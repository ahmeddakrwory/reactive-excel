package com.example.test.demo.test.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

//@Component
public class SocketTextHandler  extends TextWebSocketHandler {
    private  WebSocketSession session;
    private  TextMessage message;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();

        session.sendMessage(new TextMessage(" file had ben writen" ));
    }

}
