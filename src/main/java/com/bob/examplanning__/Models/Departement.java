package com.bob.examplanning__.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDepartement;
    @NotBlank(message = "This field is required")
    private String nomDepartement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enseignant> enseignants = new HashSet<>();

    public Long getIdDepartement() {
        return IdDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        IdDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
}
