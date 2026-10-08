
package com.arnouddev89.storecar_api.message;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerConfigTest {

    @InjectMocks
    private KafkaConsumerConfig kafkaConsumerConfig;

    @Test
    void deveCriarConsumerFactoryComSucesso() {
        ReflectionTestUtils.setField(kafkaConsumerConfig, "bootstrapServer", "localhost:9092");

        ConsumerFactory<String, ?> consumerFactory = kafkaConsumerConfig.consumerFactory();

        assertThat(consumerFactory).isNotNull();
        assertThat(consumerFactory.getConfigurationProperties()).containsKey("bootstrap.servers");
    }

    @Test
    void deveCriarKafkaListenerContainerFactoryComSucesso() {
        ReflectionTestUtils.setField(kafkaConsumerConfig, "bootstrapServer", "localhost:9092");

        ConcurrentKafkaListenerContainerFactory<String, ?> factory = kafkaConsumerConfig.kafkaListenerContainerFactory();

        assertThat(factory).isNotNull();
        assertThat(factory.getConsumerFactory()).isNotNull();
    }

    @Test
    void deveConfigurarBootstrapServerCorretamente() {
        ReflectionTestUtils.setField(kafkaConsumerConfig, "bootstrapServer", "localhost:9092");

        ConsumerFactory<String, ?> factory = kafkaConsumerConfig.consumerFactory();

        assertThat(factory.getConfigurationProperties().get("bootstrap.servers")).isEqualTo("localhost:9092");
    }
}

