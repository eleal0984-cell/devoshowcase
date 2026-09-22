package com.ejm.devshowcase_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejm.devshowcase_api.dto.ProfileDTO;
import com.ejm.devshowcase_api.service.ProfileService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfileDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> save(@RequestBody @Valid ProfileDTO dto) {
        ProfileDTO created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}