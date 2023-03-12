package com.websocket.lab6websocket.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.http.WebSocket;

public class MyThread implements Runnable {

    private WebSocketSession webSocketSession;

    public MyThread(WebSocketSession webSocketSession) {
        this.webSocketSession = webSocketSession;
    }

    @Override
    public void run() {
        if(webSocketSession.isOpen()) {
            try {
                webSocketSession.sendMessage(new TextMessage("Message from server!"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
