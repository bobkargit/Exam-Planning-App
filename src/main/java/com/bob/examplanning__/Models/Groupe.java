package com.bob.examplanning__.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdGroupe;
    @NotBlank(message = "This field is required")
    private String nomGroupe;

    public Long getIdGroupe() {
        return IdGroupe;
    }

    public void setIdGroupe(Long idGroupe) {
        IdGroupe = idGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }
}
