package com.devrodrigues.atividadeassessment.datasources.message;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.repositories.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public void notifyEvaluation(Submit event) {
            try {
                String json = mapper.writeValueAsString(event);
                jmsTemplate.convertAndSend("activity.submitted.queue", json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
    }
}
