package com.entrega1.entrega1.dto;

import com.entrega1.entrega1.models.MediaType;
import jakarta.validation.constraints.NotNull;

public record MediaDTO(
        @NotNull(message = "El tipo de media es obligatorio")
        MediaType mediaType,

        @NotNull(message = "Debe estar asociado a un plan de venganza")
        Integer revengePlanId
) {}
