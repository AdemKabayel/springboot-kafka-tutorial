package net.javaguides.springboot_kafka_tutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    // using log4j to log in message
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // creating the kafka template
    private final KafkaTemplate<String, String> kafkaTemplate;

    // creating KafkaProducer constructor
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // a new method to send a message
    public void sendMessage(String message) {

        LOGGER.info("Message sent to Kafka {}", message);

        this.kafkaTemplate.send("javaGuides", message);
    }

}
