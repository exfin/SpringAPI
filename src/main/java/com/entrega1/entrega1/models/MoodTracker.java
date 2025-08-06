package com.entrega1.entrega1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "moodtrackers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String note;

    @Min(1)
    @Max(10)
    private int moodLevel;

    @CreationTimestamp
    private LocalDate created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoodTracker)) return false;
        return id == ((MoodTracker) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
