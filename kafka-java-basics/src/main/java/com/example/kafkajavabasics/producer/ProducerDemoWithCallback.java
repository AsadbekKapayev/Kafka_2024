package com.example.kafkajavabasics.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoWithCallback {

  private static final Logger log = LoggerFactory.getLogger(ProducerDemoWithCallback.class.getSimpleName());

  public static void main(String[] args) throws InterruptedException {
    log.info("hello world");

    // create Producer Properties
    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "127.0.0.1:5006");

    properties.setProperty("key.serializer", StringSerializer.class.getName());
    properties.setProperty("value.serializer", StringSerializer.class.getName());

    properties.setProperty("batch.size", "400");
//    properties.setProperty("partitioner.class", RoundRobinPartitioner.class.getName()); this partitioner is not effective, by default sticky partitioner

    // create the Producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    for (int i = 0; i < 10; i++) {

      for (int j = 0; j < 10; j++) {
        // create a Producer Record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java", "hello world_" + i);

        // send data
        producer.send(producerRecord, new Callback() {
          @Override
          public void onCompletion(RecordMetadata metadata, Exception exception) {
            // executes every time a record successfully sent or an exception is thrown
            if (exception != null) {
              log.error("VnJZp1hh0K", exception);
              return;
            }

            log.info("Received new metadata \n" +
              "Topic: " + metadata.topic() + "\n" +
              "Partition: " + metadata.partition() + "\n" +
              "Offset: " + metadata.offset() + "\n" +
              "Timestamp: " + metadata.timestamp() + "\n");
          }
        });

        // flush and close the producer
        producer.flush();
      }

      Thread.sleep(500);

    }

    producer.close();
  }

}
