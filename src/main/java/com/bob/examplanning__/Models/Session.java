package com.bob.examplanning__.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdSession;
    @NotBlank(message = "This field is required")
    private String nomFiliere;

    public Long getIdSession() {
        return IdSession;
    }

    public void setIdSession(Long idSession) {
        IdSession = idSession;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }
}
