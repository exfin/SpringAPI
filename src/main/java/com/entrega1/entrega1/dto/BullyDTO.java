package com.entrega1.entrega1.dto;

import com.entrega1.entrega1.models.HighSchoolRole;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BullyDTO(
        @Nullable
        Integer id,

        @NotBlank(message = "El nombre no puede estar vacío")
        String name,

        @NotBlank(message = "El apodo no puede estar vacío")
        String nickname,

        @NotNull(message = "El rol en el colegio es obligatorio")
        HighSchoolRole highSchoolRole,

        @NotBlank(message = "Debe indicar la razón del bullying")
        String bulliyngReason,

        @NotNull(message = "El nivel de molestia es obligatorio")
        @Min(value = 1, message = "Nivel mínimo permitido: 1")
        @Max(value = 10, message = "Nivel máximo permitido: 10")
        Integer levelOfAnnoyance,

        @NotNull
        Integer cliqueId
) {}
