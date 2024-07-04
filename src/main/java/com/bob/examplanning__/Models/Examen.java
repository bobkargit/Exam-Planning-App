package com.bob.examplanning__.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    private String nomExamen;

    private LocalDateTime dateHeureDebut;
    private String semester;

    private String session;
    private String typeExam;
    private String dureePrevue;
    private String dureeReelle;
    private String cordinateurExam;
    private String epreuve;

    private String pv;

    private String rapport;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Surveillance> surveillances = new HashSet<>();

    public String getCordinateurExam() {
        return cordinateurExam;
    }

    public void setCordinateurExam(String cordinateurExam) {
        this.cordinateurExam = cordinateurExam;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTypeExam() {
        return typeExam;
    }

    public void setTypeExam(String typeExam) {
        this.typeExam = typeExam;
    }

    public String getDureePrevue() {
        return dureePrevue;
    }

    public void setDureePrevue(String dureePrevue) {
        this.dureePrevue = dureePrevue;
    }

    public String getDureeReelle() {
        return dureeReelle;
    }

    public void setDureeReelle(String dureeReelle) {
        this.dureeReelle = dureeReelle;
    }

    public String getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(String epreuve) {
        this.epreuve = epreuve;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public Set<Surveillance> getSurveillances() {
        return surveillances;
    }

    public void setSurveillances(Set<Surveillance> surveillances) {
        this.surveillances = surveillances;
    }
}
