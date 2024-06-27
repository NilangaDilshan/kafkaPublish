package com.dilshan.kafkaProducer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Slf4j
class AbstractContainerBaseTest {
static final KafkaContainer kafka;
	static {
		kafka=new KafkaContainer();
		kafka.start();
	}
	@DynamicPropertySource
	static void dynamicPropertySource(final DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);

	}
}
