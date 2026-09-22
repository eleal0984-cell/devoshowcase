package com.ejm.devshowcase_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ejm.devshowcase_api.dto.TechnologyDTO;
import com.ejm.devshowcase_api.model.Technology;
import com.ejm.devshowcase_api.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository repository;

    public TechnologyService(TechnologyRepository repository) {
        this.repository = repository;
    }

    public List<TechnologyDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(tech -> new TechnologyDTO(tech.getId(), tech.getName()))
                .toList();
    }

    public TechnologyDTO save(TechnologyDTO dto) {
        Technology entity = new Technology(dto.name());
        entity = repository.save(entity);
        return new TechnologyDTO(entity.getId(), entity.getName());
    }
}