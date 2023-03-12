package com.webflux.lab6webflux.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalTime;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    private int x = 10;

    @GetMapping(value = "/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getChatMessage() {
        return messageRepository.findAll();
    }

    @GetMapping(value = "/messages/{room}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessageByRoom(@PathVariable String room) {
        return messageRepository.getMessagesByRoom(room);
    }

    @Scheduled(fixedRate = 3000)
    public void saveMessage() {
        System.out.println("Message Send to ID :"+x);
        messageRepository.save(new Message(x, "Message at created at : "+ LocalTime.now(), "Suite Room")).block();
        x++;
    }
}
