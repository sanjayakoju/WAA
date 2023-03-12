package webflux.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    private int x = 10;

    @GetMapping(value = "/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getAllMessages() {
        return messageRepository.getMessagesByRoom("Suite Room");
    }

    @Scheduled(fixedRate = 3000)
    public void saveMessage() {
        System.out.println("Message Send to ID :"+10);
        messageRepository.save(new Message(x, "Hello, How are you", "Suite Room")).block();
        x++;
    }
}
