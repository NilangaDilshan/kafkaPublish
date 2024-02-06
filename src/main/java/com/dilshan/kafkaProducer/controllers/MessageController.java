package com.dilshan.kafkaProducer.controllers;

import com.dilshan.kafkaProducer.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<?> publish(
            @RequestBody Message message) {
        kafkaTemplate.send("firstTopic", message.getMessageBody());
        return ResponseEntity.ok(message);
    }
}
