package com.devrodrigues.atividadeassessment.datasources.database.mappers;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.datasources.database.entities.ActivityEntity;
import com.devrodrigues.atividadeassessment.datasources.database.entities.SubmitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubmitEntityMapper {

    SubmitEntityMapper INSTANCE = Mappers.getMapper(SubmitEntityMapper.class);

    @Mapping(source = "atividadeId", target = "activity", qualifiedByName = "mapActivityEntity")
    SubmitEntity map(Submit submit);

    @Mapping(source = "activity.id", target = "atividadeId")
    Submit map(SubmitEntity entity);


    @Named("mapActivityEntity")
    default ActivityEntity mapActivityEntity(Long atividadeId) {
        if (atividadeId == null) {
            return null;
        }
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(atividadeId);
        return activityEntity;
    }
}
