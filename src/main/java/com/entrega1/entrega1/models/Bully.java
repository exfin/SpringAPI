package com.entrega1.entrega1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bullies")
public class Bully {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private HighSchoolRole highSchoolRole;

    private String bulliyngReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clique_id", nullable = false)
    @JsonBackReference
    private Clique clique;

    @Min(1)
    @Max(10)
    private int levelOfAnnoyance;

    @OneToMany(mappedBy = "bully", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<RevengePlan> revengePlans = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bully)) return false;
        return id == ((Bully) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
