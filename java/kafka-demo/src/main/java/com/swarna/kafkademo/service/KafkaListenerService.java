package com.swarna.kafkademo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaListenerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerService.class);
    Map<String, String> map = new HashMap<>();

    @KafkaListener(topics = "${kafka.topic}", groupId = "spring_boot_consumer")
    public void print(ConsumerRecord<String, String> payload) {
        String key = payload.key();
        String value = payload.value();
        logger.info("Kafka Message:");
        logger.info(String.format("key: %s, \nvalue: %s", key, value));
        map.put(key, value);
    }

    public Map<String, String> consume() {
        return map;
    }

}