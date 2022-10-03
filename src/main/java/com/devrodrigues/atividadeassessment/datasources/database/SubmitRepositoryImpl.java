package com.devrodrigues.atividadeassessment.datasources.database;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.datasources.database.mappers.SubmitEntityMapper;
import com.devrodrigues.atividadeassessment.datasources.database.repositories.SubmitEntityRepository;
import com.devrodrigues.atividadeassessment.repositories.SubmitRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmitRepositoryImpl implements SubmitRepository {

    private final SubmitEntityRepository repository;

    private final SubmitEntityMapper mapper = SubmitEntityMapper.INSTANCE;

    public SubmitRepositoryImpl(SubmitEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Submit store(Submit submit) {
        var entity = mapper.map(submit);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    @Override
    public List<Submit> list() {
        var entities = repository.findAll();
        return entities.stream().map(mapper::map).toList();
    }

    @Override
    public Submit getById(Long submitId) {
        var entity = repository.findById(submitId).orElseThrow();
        return mapper.map(entity);
    }
}
