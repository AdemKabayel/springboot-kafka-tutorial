package net.javaguides.springboot_kafka_tutorial.controller;

import net.javaguides.springboot_kafka_tutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    // inject kafka producer
    // dependency injection
    private final KafkaProducer kafkaProducer;


    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    // query parameter this part publish(String message)
    public ResponseEntity<String> publish(@RequestParam("message") String message) {

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}

// this thing is for sending message to the kafka topic
