package com.entrega1.entrega1.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity()
@Table(name="moodtrackers")
@Data//getters y setters
@NoArgsConstructor// constructor vacio
@AllArgsConstructor//constructor completo

public class MoodTracker {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String note;

    @Min(1)
    @Max(10)
    private int moodLevel;

    @CreationTimestamp
    private LocalDate created;
}
