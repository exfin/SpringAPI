package com.entrega1.entrega1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity()
@Table(name="bullies")
@Data//getters y setters
@NoArgsConstructor// constructor vacio
@AllArgsConstructor//constructor completo



public class Bully {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private HighSchoolRole highSchoolRole;

    private String bulliyngReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clique_id", nullable = false)
    @JsonIgnore
    private Clique clique;

    @Min(1)
    @Max(10)
    private int levelOfAnnoyance;

    @OneToMany(mappedBy ="bully", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private Set<RevengePlan> revengePlans;
}
