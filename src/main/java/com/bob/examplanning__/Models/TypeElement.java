package com.bob.examplanning__.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class TypeElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdTypeElement;
    @NotBlank(message = "This field is required")
    private String titre;

    @NotBlank(message = "This field is required")
    private String duree;


    public Long getIdTypeElement() {
        return IdTypeElement;
    }

    public void setIdTypeElement(Long idTypeElement) {
        IdTypeElement = idTypeElement;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}

