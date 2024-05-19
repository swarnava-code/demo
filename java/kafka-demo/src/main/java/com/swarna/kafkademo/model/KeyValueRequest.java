package com.swarna.kafkademo.model;

import lombok.Data;

@Data
public class KeyValueRequest {
    String key;
    String value;
}
