package com.example.kafkajavabasics.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

  public static void main(String[] args) {
    log.info("hello world");

    // create Producer Properties
    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "127.0.0.1:5006");

    properties.setProperty("key.serializer", StringSerializer.class.getName());
    properties.setProperty("value.serializer", StringSerializer.class.getName());

    // create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    // create a Producer Record
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", "hello world");

    // send data
    producer.send(producerRecord);

    // flush and close the producer
    producer.flush();
    producer.close();
  }

}
