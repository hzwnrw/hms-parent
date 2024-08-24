package com.hzwn.hms.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {

	private final String bootstrapServers = "localhost:9092";

	// Producer Configuration
	public Map<String, Object> producerProperties(KafkaProperties p) {

		Map<String, Object> producerProperties = p.buildProducerProperties();

		producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

		producerProperties.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);

		producerProperties.put(ProducerConfig.RETRIES_CONFIG, 3);

		producerProperties.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 1000);// 1000ms

		producerProperties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		producerProperties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

		return producerProperties;

	}

	// Consumer Configuration
	public Map<String, Object> consumerProperties(KafkaProperties p) {

		Map<String, Object> consumerProperties = p.buildConsumerProperties();

		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		consumerProperties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 20);
		consumerProperties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 300000);

		return consumerProperties;
	}

}