package com.waynebui.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("local")
public class KafkaConfiguration {

    /**
     *
     * After run spring project, a topic will be created
     * List topics by command:
     * ./kafka-topics.sh --bootstrap-server localhost:9092 --list
     *
     */
    @Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("library-events")
                .partitions(3)
                .replicas(3)
                .build();

    }
}
