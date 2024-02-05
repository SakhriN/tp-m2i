package org.example.demo1.models;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_co;
    Date datecons;
    String nom_medecin;

    @ManyToOne
    @JoinColumn(name = "id_pa")
    Patient patient;

    @OneToMany(mappedBy = "consultation")
    List<FicheSoin> ficheSoins;

    @OneToMany(mappedBy = "consultation")
    List<Prescription> prescriptions;

    public int getId() {
        return id_co;
    }

    public void setId(int id_co) {
        this.id_co = id_co;
    }

    public Date getDatecons() {
        return datecons;
    }

    public void setDatecons(Date datecons) {
        this.datecons = datecons;
    }

    public String getNom_medecin() {
        return nom_medecin;
    }

    public void setNom_medecin(String nom_medecin) {
        this.nom_medecin = nom_medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Consultation() {
    }

    public Consultation(Date datecons, String nom_medecin) {
        this.datecons = datecons;
        this.nom_medecin = nom_medecin;
    }

    public Consultation(Date datecons, String nom_medecin, Patient patient) {
        this.datecons = datecons;
        this.nom_medecin = nom_medecin;
        this.patient = patient;
    }

    public Consultation(int id_co, Date datecons, String nom_medecin, Patient patient) {
        this.id_co = id_co;
        this.datecons = datecons;
        this.nom_medecin = nom_medecin;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Consultation : " +
                "id = " + id_co +
                ", datecons = " + datecons +
                ", nom_medecin = " + nom_medecin +
                ", fiches_soin = " + ficheSoins +
                ", prescriptions = " + prescriptions +
                ". ";
    }
}
