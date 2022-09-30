package com.devrodrigues.atividadeassessment.datasources.database.repositories;

import com.devrodrigues.atividadeassessment.datasources.database.entities.SubmitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitEntityRepository extends JpaRepository<SubmitEntity, Long> {
}
