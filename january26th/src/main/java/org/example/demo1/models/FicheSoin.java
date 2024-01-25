package org.example.demo1.models;

import javax.persistence.*;

@Entity
@Table(name = "fichesoin")
public class FicheSoin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type_soin;

    int duree_fi;

    @ManyToOne
    Consultation consultation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_soin() {
        return type_soin;
    }

    public void setType_soin(String type_soin) {
        this.type_soin = type_soin;
    }

    public int getDuree_fi() {
        return duree_fi;
    }

    public void setDuree_fi(int duree_fi) {
        this.duree_fi = duree_fi;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public FicheSoin() {
    }

    public FicheSoin(String type_soin, int duree_fi) {
        this.type_soin = type_soin;
        this.duree_fi = duree_fi;
    }

    public FicheSoin(String type_soin, int duree_fi, Consultation consultation) {
        this.type_soin = type_soin;
        this.duree_fi = duree_fi;
        this.consultation = consultation;
    }

    public FicheSoin(int id, String type_soin, int duree_fi, Consultation consultation) {
        this.id = id;
        this.type_soin = type_soin;
        this.duree_fi = duree_fi;
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "FicheSoin : " +
                "id = " + id +
                ", type_soin = " + type_soin +
                ", duree_fi = " + duree_fi +
                ", consultation = " + consultation +
                ". ";
    }

}
