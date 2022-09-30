package com.devrodrigues.atividadeassessment.entrypoint.mappers;

import com.devrodrigues.atividadeassessment.core.Submit;
import com.devrodrigues.atividadeassessment.openapi.model.CreateSubmitActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.OffsetDateTime;

@Mapper
public interface SubmitActivityMappers {

    SubmitActivityMappers INSTANCE = Mappers.getMapper(SubmitActivityMappers.class);

    @Mapping(target = "createdAt", expression = "java(Instant.now())")
    Submit map(CreateSubmitActivity dto);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "instantToOffsetDateTime")
    com.devrodrigues.atividadeassessment.openapi.model.Submit map(Submit submit);

    @Named("instantToOffsetDateTime")
    default OffsetDateTime map(Instant instant) {
        return instant.atOffset(OffsetDateTime.now().getOffset());
    }
}
