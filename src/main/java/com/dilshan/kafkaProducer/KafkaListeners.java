package com.dilshan.kafkaProducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {

    @KafkaListener(topics = {"firstTopic"}, groupId = "groupId")
    void listener(String data) {
        log.info("This is received data: {} 😂", data);
    }
}
