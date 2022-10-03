package com.devrodrigues.atividadeassessment.services;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.repositories.SubmitRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    private final SubmitRepository repository;

    public EvaluationService(SubmitRepository repository) {
        this.repository = repository;
    }

    public void setNote(Long submitId, Long note) {

        var submit = repository.getById(submitId);
        var submitUpdated = new Submit(
                submit.id(),
                submit.alunoId(),
                submit.atividadeId(),
                submit.resposta(),
                submit.createdAt(),
                note
        );
        repository.store(submitUpdated);
    }
}
