package com.devrodrigues.atividadeassessment.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.logging.Logger;

@Configuration
public class JMSConfiguration {

    private final Logger logger = Logger.getLogger(JMSConfiguration.class.getName());
    @Value("${artemis.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
        logger.info("broker url: " + brokerUrl);

        return new ActiveMQConnectionFactory(brokerUrl, "AMQ_USER", "AMQ_PASSWORD");
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(
                senderActiveMQConnectionFactory());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(cachingConnectionFactory());
    }
}
