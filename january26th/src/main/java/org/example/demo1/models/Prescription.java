package org.example.demo1.models;

import javax.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type_medicament;

    int duree_pr;

    @ManyToOne
    @JoinColumn
    Consultation consultation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_medicament() {
        return type_medicament;
    }

    public void setType_medicament(String type_medicament) {
        this.type_medicament = type_medicament;
    }

    public int getDuree_pr() {
        return duree_pr;
    }

    public void setDuree_pr(int duree_pr) {
        this.duree_pr = duree_pr;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Prescription() {
    }

    public Prescription(String type_medicament, int duree_pr) {
        this.type_medicament = type_medicament;
        this.duree_pr = duree_pr;
    }

    public Prescription(String type_medicament, int duree_pr, Consultation consultation) {
        this.type_medicament = type_medicament;
        this.duree_pr = duree_pr;
        this.consultation = consultation;
    }

    public Prescription(int id, String type_medicament, int duree_pr, Consultation consultation) {
        this.id = id;
        this.type_medicament = type_medicament;
        this.duree_pr = duree_pr;
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Prescription : " +
                "id = " + id +
                ", type_medicament = " + type_medicament +
                ", duree_pr = " + duree_pr +
                ", consultation = " + consultation +
                ". ";
    }

}



