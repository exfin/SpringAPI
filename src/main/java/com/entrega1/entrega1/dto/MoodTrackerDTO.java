package com.entrega1.entrega1.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record MoodTrackerDTO(
        @NotBlank(message = "La nota no puede estar vacía")
        String note,

        @Min(value = 1, message = "El nivel mínimo es 1")
        @Max(value = 10, message = "El nivel máximo es 10")
        int moodLevel
) {}
