package com.patrykkuchar.app;

import java.util.Properties;

public class Main {
  public static void main(String[] args) {

    Properties properties_0 = new Properties();
    properties_0.put("bootstrap.servers", "localhost:9090");
    properties_0.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_0.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_0.put("retries", "10");

    Properties properties_1 = new Properties();
    properties_1.put("bootstrap.servers", "localhost:9091");
    properties_1.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_1.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_1.put("retries", "10");

    Properties properties_2 = new Properties();
    properties_2.put("bootstrap.servers", "localhost:9093");
    properties_2.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_2.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties_2.put("retries", "10");

    Thread producer_0 = new Thread(new Producer(properties_0), "producer_0");
    Thread producer_1 = new Thread(new Producer(properties_1), "producer_1");
    Thread producer_2 = new Thread(new Producer(properties_2), "producer_2");

    producer_0.start();
    producer_1.start();
    producer_2.start();
  }
}
