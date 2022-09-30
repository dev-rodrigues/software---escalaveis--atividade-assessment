package com.devrodrigues.atividadeassessment.entrypoint.mappers;

import com.devrodrigues.atividadeassessment.core.Activity;
import com.devrodrigues.atividadeassessment.openapi.model.CreateActivity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityHttpMappers {

    ActivityHttpMappers INSTANCE = Mappers.getMapper(ActivityHttpMappers.class);

    Activity map(CreateActivity dto);

    com.devrodrigues.atividadeassessment.openapi.model.Activity map(Activity activity);
}
