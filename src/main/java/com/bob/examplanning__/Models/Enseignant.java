package com.bob.examplanning__.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Enseignant extends Personnel {

    @ManyToMany(mappedBy = "enseignants")
    private Set<Surveillance> surveillances = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    public Set<Surveillance> getSurveillances() {
        return surveillances;
    }

    public void setSurveillances(Set<Surveillance> surveillances) {
        this.surveillances = surveillances;
    }

    public Departement getDepartement() {
        return departement;
    }


    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}

