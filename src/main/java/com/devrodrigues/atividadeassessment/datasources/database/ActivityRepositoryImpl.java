package com.devrodrigues.atividadeassessment.datasources.database;

import com.devrodrigues.atividadeassessment.core.Activity;
import com.devrodrigues.atividadeassessment.datasources.database.entities.ActivityEntity;
import com.devrodrigues.atividadeassessment.datasources.database.mappers.ActivityEntityMapper;
import com.devrodrigues.atividadeassessment.datasources.database.repositories.ActivityEntityRepository;
import com.devrodrigues.atividadeassessment.repositories.ActivityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class ActivityRepositoryImpl implements ActivityRepository {

    private final ActivityEntityRepository repository;
    private final ActivityEntityMapper mapper = ActivityEntityMapper.INSTANCE;

    public ActivityRepositoryImpl(ActivityEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Activity store(Activity activity) {
        var entity = mapper.map(activity);
        var saved = repository.save(entity);
        return mapper.map(entity);
    }

    @Override
    public List<Activity> list() {
        var entities = repository.findAll();
        return entities.stream().map(mapper::map).collect(toList());
    }

    @Override
    public Activity findBy(Long id) {
        var entity = getById(id);
        return mapper.map(entity.orElseThrow(() -> new RuntimeException("Atividade não encontrada")));
    }

    public Optional<ActivityEntity> getById(Long id) {
        return repository.findById(id);
    }


    @Override
    public List<Activity> findBy(String filter) {
        var queryFilter = filter.equals("DEVIDA");

        var activities = list();

        if (queryFilter) {
            return activities.stream()
                    .filter(it -> it.getSubmissoes().isEmpty()).collect(toList());
        }

        return activities.stream()
                .filter(it -> !it.getSubmissoes().isEmpty()).collect(toList());
    }

    @Override
    public void delete(Long id) {
        getById(id).ifPresent(repository::delete);
    }
}
