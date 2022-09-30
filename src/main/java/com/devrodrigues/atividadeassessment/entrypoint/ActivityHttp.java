package com.devrodrigues.atividadeassessment.entrypoint;

import com.devrodrigues.atividadeassessment.openapi.api.ActivityApi;
import com.devrodrigues.atividadeassessment.openapi.model.Activity;
import com.devrodrigues.atividadeassessment.openapi.model.CreateActivity;
import com.devrodrigues.atividadeassessment.openapi.model.Error;
import com.devrodrigues.atividadeassessment.services.ActivityService;
import com.devrodrigues.atividadeassessment.entrypoint.mappers.ActivityHttpMappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ActivityHttp implements ActivityApi {

    private final ActivityService service;
    private final ActivityHttpMappers mapper = ActivityHttpMappers.INSTANCE;


    public ActivityHttp(ActivityService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Activity>> listActivities() {
        return ResponseEntity.ok(
                service.list()
                        .stream()
                        .map(ActivityHttpMappers.INSTANCE::map)
                        .collect(toList())
        );
    }

    @Override
    public ResponseEntity<Activity> activityPost(CreateActivity createActivity) {
        var activity = mapper.map(createActivity);
        var created = service.create(activity);
        var result = mapper.map(created);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(result);
    }

    @Override
    public ResponseEntity<Activity> getById(Long id) {
        var result = service.findById(id);
        var response = mapper.map(result);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<Activity>> getByIdFilter(String filter) {
        var result = service.findByFilter(filter);
        var response = result.stream().map(mapper::map).collect(toList());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Error> destroy(Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
