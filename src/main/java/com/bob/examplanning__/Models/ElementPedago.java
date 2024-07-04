package com.bob.examplanning__.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ElementPedago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElement;

    @NotBlank(message = "This field is required")
    private String titre;

    @NotBlank(message = "This field is required")
    private String niveau;

    @NotBlank(message = "This field is required")
    private String typeElement;

    @NotBlank(message = "This field is required")
    private String coordinateur;

    @NotBlank(message = "This field is required")
    private String enseignant;

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(String typeElement) {
        this.typeElement = typeElement;
    }

    public String getCoordinateur() {
        return coordinateur;
    }

    public void setCoordinateur(String coordinateur) {
        this.coordinateur = coordinateur;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }
}
