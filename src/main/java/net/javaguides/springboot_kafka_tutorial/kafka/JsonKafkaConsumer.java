package net.javaguides.springboot_kafka_tutorial.kafka;


import net.javaguides.springboot_kafka_tutorial.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaGuides_json", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info("Json message received: {}", user.toString());
    }
}

// json deserializer, spring kafka provided JsonDeserializer will convert User JSON object into Java User object
