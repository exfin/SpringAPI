package com.entrega1.entrega1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliques")
public class Clique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "clique", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Bully> bullies = new HashSet<>();

    public void addBully(Bully bully) {
        this.bullies.add(bully);
        bully.setClique(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clique)) return false;
        return id == ((Clique) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
