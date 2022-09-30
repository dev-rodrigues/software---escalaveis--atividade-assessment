package com.devrodrigues.atividadeassessment.datasources.database.mappers;

import com.devrodrigues.atividadeassessment.core.Activity;
import com.devrodrigues.atividadeassessment.datasources.database.entities.ActivityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActivityEntityMapper {

    ActivityEntityMapper INSTANCE = Mappers.getMapper(ActivityEntityMapper.class);
    ActivityEntity map(Activity activity);

    Activity map(ActivityEntity entity);
}
