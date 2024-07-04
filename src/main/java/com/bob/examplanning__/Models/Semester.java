package com.bob.examplanning__.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdSemester;
    @NotBlank(message = "This field is required")
    private String nomSemester;

    public Long getIdSemester() {
        return IdSemester;
    }

    public void setIdSemester(Long idSemester) {
        IdSemester = idSemester;
    }

    public String getNomSemester() {
        return nomSemester;
    }

    public void setNomSemester(String nomSemester) {
        this.nomSemester = nomSemester;
    }
}
