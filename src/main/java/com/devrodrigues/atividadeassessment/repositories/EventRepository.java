package com.devrodrigues.atividadeassessment.repositories;

import com.devrodrigues.atividadeassessment.core.Submit;

public interface EventRepository {
    void notifyEvaluation(Submit event);
}
