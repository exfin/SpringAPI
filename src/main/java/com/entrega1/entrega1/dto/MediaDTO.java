package com.entrega1.entrega1.dto;

import com.entrega1.entrega1.models.MediaType;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record MediaDTO(

        @Nullable
        String id,

        @NotNull(message = "El tipo de media es obligatorio")
        MediaType mediaType,

        @NotNull(message = "Debe estar asociado a un plan de venganza")
        Integer revengePlanId,

        @NotNull(message = "Debe contener una URL")
        String url,

        @NotNull(message = "Debe contener una descripción")
        String caption
) {}
