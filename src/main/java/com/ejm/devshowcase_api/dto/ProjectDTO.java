package com.ejm.devshowcase_api.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record ProjectDTO(
    Long id,

    @NotBlank(message = "O título é obrigatório")
    String title,

    @NotBlank(message = "A descrição é obrigatória")
    String description,

    @NotBlank(message = "A URL é obrigatória")
    @URL(message = "Informe uma URL válida")
    String url,

    Long profileId
) {}