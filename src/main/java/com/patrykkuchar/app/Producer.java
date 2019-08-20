package com.patrykkuchar.app;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer implements Runnable {

  private final Properties properties;

  Producer(Properties properties) {
    this.properties = properties;
  }

  @Override
  public void run() {
    try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)) {
      for (int i = 0; i < 30; i++) {
        System.out.println("Thread " + Thread.currentThread().getName() + " sending message no " + i);
        kafkaProducer.send(new ProducerRecord<>("topic", Integer.toString(i), "test message - " + i));
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    System.out.println("Messages sent");
  }
}
