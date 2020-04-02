package io.macaca.controller;


import io.macaca.models.entities.Project;
import io.macaca.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value ="/api/v1/project",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping(value = "")
    public List<Project> getAll() {
        return service.getAll();
    }
}
