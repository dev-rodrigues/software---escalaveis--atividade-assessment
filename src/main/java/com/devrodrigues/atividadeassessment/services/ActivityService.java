package com.devrodrigues.atividadeassessment.services;

import com.devrodrigues.atividadeassessment.core.Activity;
import com.devrodrigues.atividadeassessment.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public Activity create(Activity activity) {
        return repository.store(activity);
    }

    public List<Activity> list() {
        return repository.list();
    }

    public Activity findById(@NotNull Long id) {
        return repository.findBy(id);
    }

    public List<Activity> findByFilter(@NotNull String filter) {
        return repository.findBy(filter);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
