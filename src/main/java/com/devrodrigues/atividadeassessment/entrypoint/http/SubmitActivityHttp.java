package com.devrodrigues.atividadeassessment.entrypoint.http;

import com.devrodrigues.atividadeassessment.entrypoint.http.mappers.SubmitActivityMappers;
import com.devrodrigues.atividadeassessment.openapi.api.SubmitApi;
import com.devrodrigues.atividadeassessment.openapi.model.CreateSubmitActivity;
import com.devrodrigues.atividadeassessment.openapi.model.Submit;
import com.devrodrigues.atividadeassessment.services.SubmitActivityService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubmitActivityHttp implements SubmitApi {

    private final SubmitActivityService service;
    private final SubmitActivityMappers mapper = Mappers.getMapper(SubmitActivityMappers.class);


    public SubmitActivityHttp(SubmitActivityService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Submit>> listSubmissions() {
        var result = service.list();
        var response = result.stream().map(mapper::map).toList();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Submit> submitPost(CreateSubmitActivity createSubmitActivity) {
        var submit = mapper.map(createSubmitActivity);
        var result = service.create(submit);
        return ResponseEntity.ok(mapper.map(result));
    }
}
