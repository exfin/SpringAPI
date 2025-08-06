package com.entrega1.entrega1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "revengeplans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RevengePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String description;

    private Boolean isExecuted;

    private LocalDate datePlanned;

    @Enumerated(EnumType.STRING)
    private SuccessLevel successLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bully_id", nullable = false)
    @JsonIgnore
    private Bully bully;

    @OneToMany(mappedBy = "revengePlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Media> media = new HashSet<>();


    public void addMedia(Media media) {
        this.media.add(media);
        media.setRevengePlan(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RevengePlan)) return false;
        return id == ((RevengePlan) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
