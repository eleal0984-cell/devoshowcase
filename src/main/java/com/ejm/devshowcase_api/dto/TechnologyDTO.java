package com.ejm.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;

public record TechnologyDTO(
    Long id,

    @NotBlank(message = "O nome é obrigatório")
    String name
) {}