package com.bob.examplanning__.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
@Entity
public class typeExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdTypeExam;
    @NotBlank(message = "This field is required")
    private String intitule;

    @NotBlank(message = "This field is required")
    private String duree;



    public Long getIdTypeExam() {
        return IdTypeExam;
    }

    public void setIdTypeExam(Long idTypeExam) {
        IdTypeExam = idTypeExam;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
