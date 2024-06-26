package org.example.demo1.models;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_pa;

    String nom, prenom, photo;

    Date dateNais;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    List<Consultation> consultationList;


    public int getId() {
        return id_pa;
    }

    public void setId(int id) {
        this.id_pa = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    public Patient() {
    }

    public Patient(String nom, String prenom, String photo, Date dateNais) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.dateNais = dateNais;
    }

    @Override
    public String toString() {
        return "Patient : " +
                "id = " + id_pa +
                ", nom = " + nom +
                ", prenom = " + prenom +
                ", photo = " + photo +
                ", dateNais = " + dateNais +
                ". ";
    }
}
