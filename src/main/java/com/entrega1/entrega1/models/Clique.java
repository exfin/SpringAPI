package com.entrega1.entrega1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity()
@Table(name="cliques")
@Data//getters y setters
@NoArgsConstructor// constructor vacio
@AllArgsConstructor//constructor completo
public class Clique {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String nome;

    private String description;

    @OneToMany(mappedBy ="clique", cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnore
    private Set<Bully> bullies;



}
