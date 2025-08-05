package com.entrega1.entrega1.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name="medias")
@Data//getters y setters
@NoArgsConstructor// constructor vacio
@AllArgsConstructor//constructor completo
public class Media {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "revengePlan_id", nullable = false)
    @JsonIgnore
    private RevengePlan revengePlan;
}
