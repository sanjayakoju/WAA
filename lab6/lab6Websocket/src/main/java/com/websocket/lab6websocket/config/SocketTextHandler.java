package com.websocket.lab6websocket.config;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("Connected");

        session.sendMessage(new TextMessage("Connected!"));
        MyThread myThread = new MyThread(session);
        Thread thread = new Thread(myThread);
        thread.start();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        System.out.println("Got Message : "+message);
        DoubleEvaluator eval = new DoubleEvaluator();
        Double result = null;
        try {
            result = eval.evaluate(message.getPayload());
        } catch (Exception ex) {
            System.out.println(ex);
            session.sendMessage(new TextMessage("Invalid Expression!"));
        }

        String output = "Result = "+ message.getPayload() +" : "+ result;
        System.out.println("Result : "+output);
        session.sendMessage(new TextMessage(output));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("Connection closed!");
        session.sendMessage(new TextMessage("Connection Closed!"));
    }
}
