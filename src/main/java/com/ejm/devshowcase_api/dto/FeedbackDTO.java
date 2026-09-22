package com.ejm.devshowcase_api.dto;

import jakarta.validation.constraints.NotNull;

public record FeedbackDTO(
    Long id,

    @NotNull(message = "A nota é obrigatória")
    Integer score,

    String comment,

    Long projectId
) {}
