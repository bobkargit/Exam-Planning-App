package com.bob.examplanning__.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFiliere;
    @NotBlank(message = "This field is required")
    private String nomFiliere;

    public Long getIdFiliere() {
        return IdFiliere;
    }

    public void setIdFiliere(Long idFiliere) {
        IdFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }
}
