package com.ejm.devshowcase_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ejm.devshowcase_api.dto.ProfileDTO;
import com.ejm.devshowcase_api.model.Profile;
import com.ejm.devshowcase_api.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<ProfileDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(p -> new ProfileDTO(p.getId(), p.getName(), p.getRole()))
                .toList();
    }

    public ProfileDTO findById(Long id) {
        Profile profile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        return new ProfileDTO(profile.getId(), profile.getName(), profile.getRole());
    }

    public ProfileDTO save(ProfileDTO dto) {
        Profile entity = new Profile();
        entity.setName(dto.name());
        entity.setRole(dto.role());
        entity = repository.save(entity);
        return new ProfileDTO(entity.getId(), entity.getName(), entity.getRole());
    }
}
