package com.ejm.devshowcase_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ejm.devshowcase_api.dto.ProjectDTO;
import com.ejm.devshowcase_api.model.Project;
import com.ejm.devshowcase_api.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<ProjectDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(p -> new ProjectDTO(
                        p.getId(), 
                        p.getTitle(), 
                        p.getDescription(), 
                        p.getUrl(),
                        p.getProfile() != null ? p.getProfile().getId() : null
                ))
                .toList();
    }

    public ProjectDTO save(ProjectDTO dto) {
        Project entity = new Project();
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setUrl(dto.url());
        entity = repository.save(entity);
        return new ProjectDTO(
                entity.getId(), 
                entity.getTitle(), 
                entity.getDescription(), 
                entity.getUrl(), 
                null
        );
    }
}