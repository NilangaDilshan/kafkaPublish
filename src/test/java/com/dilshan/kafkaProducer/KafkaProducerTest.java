package com.dilshan.kafkaProducer;

import com.dilshan.kafkaProducer.models.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureMockMvc
public class KafkaProducerTest extends AbstractContainerBaseTest{

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPushMessage() throws Exception {
        Message message = new Message();
        message.setMessageBody("Satan");
        ResultActions response = this.mockMvc.perform(post("/api/v1/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(message)));
        log.info("Response: {}", response);
        await().pollInterval(Duration.ofSeconds(3)).atMost(10, SECONDS).untilAsserted(() -> {

        });
    }
}
