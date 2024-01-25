package org.example.demo1.models;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date datecons;
    String nom_medecin;

    @ManyToOne
    Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Consultation(int id, Date datecons, String nom_medecin, Patient patient) {
        this.id = id;
        this.datecons = datecons;
        this.nom_medecin = nom_medecin;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", datecons=" + datecons +
                ", nom_medecin='" + nom_medecin + '\'' +
                ", patient=" + patient +
                '}';
    }
}
