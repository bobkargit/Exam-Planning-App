package com.bob.examplanning__.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdNiveau;
    @NotBlank(message = "This field is required")
    private String titre;



    public Long getIdNiveau() {
        return IdNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        IdNiveau = idNiveau;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
