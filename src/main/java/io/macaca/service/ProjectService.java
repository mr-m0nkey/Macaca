package io.macaca.service;

import io.macaca.exceptions.ServiceException;
import io.macaca.models.entities.Project;
import io.macaca.models.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> getAll() {
        return repository.findAll();
    }

    public void connect(String code, String path) {
        Optional<Project> projectOptional = repository.findByCode(code);
        if (!projectOptional.isPresent()) throw new ServiceException(); //TODO use correct exception
        Project project = projectOptional.get();
        String projectEndpoint = project.getEndpoint().toString() + path;
        URI projectUri;
        try {
            projectUri = new URI(projectEndpoint);
        } catch (URISyntaxException e) {
            throw new ServiceException();
        }

        //TODO call endpoint


    }


}
