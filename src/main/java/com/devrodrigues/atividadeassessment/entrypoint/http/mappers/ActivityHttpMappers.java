package com.devrodrigues.atividadeassessment.entrypoint.http.mappers;

import com.devrodrigues.atividadeassessment.core.Activity;
import com.devrodrigues.atividadeassessment.openapi.model.CreateActivity;
import org.mapstruct.Mapper;

@Mapper
public interface ActivityHttpMappers {

    Activity map(CreateActivity dto);

    com.devrodrigues.atividadeassessment.openapi.model.Activity map(Activity activity);
}
