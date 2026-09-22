package com.ejm.devshowcase_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejm.devshowcase_api.dto.ProjectDTO;
import com.ejm.devshowcase_api.service.ProjectService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody @Valid ProjectDTO dto) {
        ProjectDTO created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
