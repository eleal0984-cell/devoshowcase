package com.ejm.devshowcase_api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ejm.devshowcase_api.dto.FeedbackDTO;
import com.ejm.devshowcase_api.service.FeedbackService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> save(@RequestBody @Valid FeedbackDTO dto) {
        FeedbackDTO created = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}