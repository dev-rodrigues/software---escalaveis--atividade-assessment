package com.devrodrigues.atividadeassessment.services;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.repositories.EventRepository;
import com.devrodrigues.atividadeassessment.repositories.SubmitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitActivityService {


    private final SubmitRepository repository;
    private final EventRepository eventRepository;

    public SubmitActivityService(SubmitRepository repository, EventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public Submit create(Submit submit) {
        var response = repository.store(submit);
        eventRepository.notifyEvaluation(response);
        return response;
    }

    public List<Submit> list() {
        return repository.list();
    }
}