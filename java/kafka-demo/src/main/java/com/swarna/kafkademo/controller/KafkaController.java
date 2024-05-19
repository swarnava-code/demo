package com.swarna.kafkademo.controller;

import com.swarna.kafkademo.model.KeyValueRequest;
import com.swarna.kafkademo.service.KafkaListenerService;
import com.swarna.kafkademo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Autowired
    KafkaListenerService kafkaListenerService;

    @PostMapping
    public String publishMessage(@RequestBody KeyValueRequest keyValueRequest){
        kafkaProducerService.send(keyValueRequest);
        return "data published";
    }

    @GetMapping
    public Map<String, String> subscribeMessage(){
        return kafkaListenerService.consume();
    }

}
