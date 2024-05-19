package com.swarna.kafkademo.service;

import com.swarna.kafkademo.model.KeyValueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${kafka.topic}")
    private String TOPIC_NAME;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(KeyValueRequest keyValueRequest) {
        kafkaTemplate.send(TOPIC_NAME, keyValueRequest.getKey(), keyValueRequest.getValue());
    }

}