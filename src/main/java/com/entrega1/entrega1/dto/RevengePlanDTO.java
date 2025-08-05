package com.entrega1.entrega1.dto;

import com.entrega1.entrega1.models.SuccessLevel;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RevengePlanDTO(
        @NotBlank(message = "El nombre del plan no puede estar vacío")
        String name,

        @NotBlank(message = "La descripción no puede estar vacía")
        String description,

        @NotNull(message = "Debe indicar si fue ejecutado")
        Boolean isExecuted,

        @NotNull(message = "La fecha de planificación es obligatoria")
        @FutureOrPresent(message = "La fecha no puede estar en el pasado")
        LocalDate datePlanned,

        @NotNull(message = "Debe definir el nivel de éxito")
        SuccessLevel successLevel,

        @NotNull(message = "Debe estar asociado a un bully")
        Integer bullyId
) {}
