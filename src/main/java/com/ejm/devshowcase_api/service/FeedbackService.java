package com.ejm.devshowcase_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ejm.devshowcase_api.dto.FeedbackDTO;
import com.ejm.devshowcase_api.model.Feedback;
import com.ejm.devshowcase_api.repository.FeedbackRepository;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<FeedbackDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(f -> new FeedbackDTO(
                        f.getId(), 
                        f.getScore(), 
                        f.getComment(), 
                        f.getProject() != null ? f.getProject().getId() : null
                ))
                .toList();
    }

    public FeedbackDTO save(FeedbackDTO dto) {
        Feedback entity = new Feedback();
        entity.setScore(dto.score());
        entity.setComment(dto.comment());
        entity = repository.save(entity);
        return new FeedbackDTO(entity.getId(), entity.getScore(), entity.getComment(), null);
    }
}
