package com.devrodrigues.atividadeassessment.repositories;

import com.devrodrigues.atividadeassessment.core.Submit;

import java.util.List;

public interface SubmitRepository {

    Submit store(Submit submit);
    List<Submit> list();
}
