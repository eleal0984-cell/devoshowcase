package com.ejm.devshowcase_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejm.devshowcase_api.dto.TechnologyDTO;
import com.ejm.devshowcase_api.service.TechnologyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TechnologyDTO> save(@RequestBody @Valid TechnologyDTO dto) {
        TechnologyDTO created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}