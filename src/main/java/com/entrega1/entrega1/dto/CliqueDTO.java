package com.entrega1.entrega1.dto;

import jakarta.validation.constraints.NotBlank;

public record CliqueDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nome,

        @NotBlank(message = "La descripción no puede estar vacía")
        String description
) {}
