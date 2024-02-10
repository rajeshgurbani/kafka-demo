package com.rdgurbani.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        // Create Producer Properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("max.request.size", "104857600");

        // Create a producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Producer record
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("first_topic", "Hello World!");

        // send data
        producer.send(producerRecord);

        // flush producer
        producer.flush();

        producer.close();
    }
}
