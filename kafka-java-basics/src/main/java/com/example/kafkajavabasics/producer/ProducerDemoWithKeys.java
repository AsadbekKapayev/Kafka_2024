package com.example.kafkajavabasics.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithKeys {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithKeys.class.getSimpleName());

  public static void main(String[] args) throws InterruptedException {
    log.info("hello world");

    // create Producer Properties
    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "127.0.0.1:5006");

    properties.setProperty("key.serializer", StringSerializer.class.getName());
    properties.setProperty("value.serializer", StringSerializer.class.getName());

    // create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    for (int i = 0; i < 10; i++) {

      for (int j = 0; j < 2; j++) {

        var topic = "demo_java";
        var key = "id_" + i;
        var value = "hello world_" + i;

        // create a Producer Record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);

        // send data
        producer.send(producerRecord, new Callback() {
          @Override
          public void onCompletion(RecordMetadata metadata, Exception exception) {
            // executes every time a record successfully sent or an exception is thrown
            if (exception != null) {
              log.error("VnJZp1hh0K", exception);
              return;
            }

            log.info("Key: " + key + " \n" +
              "Topic: " + metadata.topic() + "\n" +
              "Partition: " + metadata.partition() + "\n" +
              "Offset: " + metadata.offset() + "\n" +
              "Timestamp: " + metadata.timestamp() + "\n");
          }
        });

      }

      // flush and close the producer
      producer.flush();
    }

    producer.close();
  }

}
