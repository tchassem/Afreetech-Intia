package com.INTIA.INTIA.assurance.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeAssurance;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client_ client;
}
