package com.devrodrigues.atividadeassessment.datasources.message;

import com.devrodrigues.atividadeassessment.repositories.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventRepositoryImpl implements EventRepository {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    public EventRepositoryImpl(JmsTemplate jmsTemplate, ObjectMapper mapper) {
        this.jmsTemplate = jmsTemplate;
        this.mapper = mapper;
    }

    @Override
    public void store(Integer event) {
        var json = mapper.convertValue(event, String.class);
        jmsTemplate.convertAndSend("activity.submitted.queue", json);
    }
}
