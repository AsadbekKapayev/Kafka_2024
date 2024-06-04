package com.example.kafkajavabasics.consumer;

import com.example.kafkajavabasics.producer.ProducerDemo;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ConsumerDemo {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

  public static void main(String[] args) {
    log.info("hello world");

    var groupId = "my-java-app";
    var topic = "demo_java";

    // create Producer Properties
    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "127.0.0.1:5006");

    properties.setProperty("key.deserializer", StringDeserializer.class.getName());
    properties.setProperty("value.deserializer", StringDeserializer.class.getName());

    properties.setProperty("group.id", groupId);

    properties.setProperty("auto.offset.reset", "earliest"); // none/earliest/latest

    // create a consumer
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

    // subscribe to a topic
    consumer.subscribe(List.of(topic));

    //poll for data
    while (true) {

      log.info("Polling...");

      ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

      for (var record : records) {
        log.info("Key: " + record.key() + ", Value: " + record.value());
        log.info("Partition: " + record.partition() + ", Offset: " + record.offset());
      }

    }

  }

}
