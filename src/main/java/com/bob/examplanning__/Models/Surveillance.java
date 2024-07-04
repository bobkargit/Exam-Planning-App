package com.bob.examplanning__.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Surveillance{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long idServeillance;
    private int nbrSurveillants;

    private String methodeAffectation;
    @ManyToMany
    @JoinTable(
            name = "Surveillance_enseignant",
            joinColumns = @JoinColumn(name = "survaillance_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id")
    )
    private Set<Enseignant> enseignants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    public String getMethodeAffectation() {
        return methodeAffectation;
    }

    public void setMethodeAffectation(String methodeAffectation) {
        this.methodeAffectation = methodeAffectation;
    }

    public int getNbrSurveillants() {
        return nbrSurveillants;
    }

    public void setNbrSurveillants(int nbrSurveillants) {
        this.nbrSurveillants = nbrSurveillants;
    }

    public Long getIdServeillance() {
        return idServeillance;
    }

    public void setIdServeillance(Long idServeillance) {
        this.idServeillance = idServeillance;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    public void addEnseignant(Enseignant enseignant){
        enseignants.add(enseignant);
    }
}
