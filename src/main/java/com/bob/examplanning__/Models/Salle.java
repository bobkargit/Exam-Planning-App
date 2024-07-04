package com.bob.examplanning__.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdSalle;
    @NotBlank(message = "This field is required")
    private String nomSalle;
    @NotNull(message = "La capacité ne peut pas être nulle")
    private Integer capacity;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Surveillance> surveillances = new HashSet<>();

    public Set<Surveillance> getSurveillances() {
        return surveillances;
    }


    public void setSurveillances(Set<Surveillance> surveillances) {
        this.surveillances = surveillances;
    }

    public Long getIdSalle() {
        return IdSalle;
    }

    public void setIdSalle(Long idSalle) {
        IdSalle = idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}
