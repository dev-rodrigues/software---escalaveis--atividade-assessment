package com.devrodrigues.atividadeassessment.datasources.database.repositories;

import com.devrodrigues.atividadeassessment.datasources.database.entities.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityEntityRepository extends JpaRepository<ActivityEntity, Long> {
}
