package com.devrodrigues.atividadeassessment.repositories;


import com.devrodrigues.atividadeassessment.core.Activity;

import java.util.List;

public interface ActivityRepository {
    Activity store(Activity activity);

    List<Activity> list();
    List<Activity> findBy(String filter);

    Activity findBy(Long id);

    void delete(Long id);
}
