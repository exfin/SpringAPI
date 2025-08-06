package com.entrega1.entrega1.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record CliqueDTO(

        @Nullable
        Integer id,

        @NotBlank(message = "El nombre no puede estar vacío")
        String name,

        @NotBlank(message = "La descripción no puede estar vacía")
        String description
) {}
