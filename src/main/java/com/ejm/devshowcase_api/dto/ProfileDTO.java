package com.ejm.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfileDTO(
    Long id,

    @NotBlank(message = "O nome é obrigatório")
    String name,

    @NotBlank(message = "O cargo é obrigatório")
    String role
) {}