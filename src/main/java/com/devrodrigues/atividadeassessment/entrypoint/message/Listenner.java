package com.devrodrigues.atividadeassessment.entrypoint.message;

import com.devrodrigues.atividadeassessment.core.Evaluation;
import com.devrodrigues.atividadeassessment.services.EvaluationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listenner {

    private final ObjectMapper mapper;
    private final EvaluationService evaluationService;

    public Listenner(ObjectMapper mapper, EvaluationService evaluationService) {
        this.mapper = mapper;
        this.evaluationService = evaluationService;
    }

    @JmsListener(destination = "activity.evaluation.queue", containerFactory = "jmsListenerContainerFactory")
    public void listen(String message) throws JsonProcessingException {
        var evaluation = mapper.readValue(message, Evaluation.class);
        evaluationService.setNote(evaluation.getSubmit().id(), Long.valueOf(evaluation.getNote()));
        System.out.println(evaluation);
    }
}
