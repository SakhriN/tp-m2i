package org.example;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Evenement {
    String name;
    int id;
    LocalDate localdate;
    LocalTime localtime;
    Lieu lieu;
    int billetsDispo;
    float price;
    int nbTicketsSold;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNbTicketsSold() {
        return nbTicketsSold;
    }

    public void setNbTicketsSold(int nbTicketsSold) {
        this.nbTicketsSold = nbTicketsSold;
    }

    //Fait par ChatGPT
    public boolean verifierDisponibiliteBillet() {
        return billetsDispo > 0;
    }

    public void vendreBillet() {
        if (verifierDisponibiliteBillet()) {
            nbTicketsSold++;
            billetsDispo--;
            System.out.println("Billet vendu avec succès.");
        } else {
            System.out.println("Désolé, plus de billets disponibles.");
        }
    }

    public void annulerVenteBillet() {
        if (nbTicketsSold > 0) {
            nbTicketsSold--;
            billetsDispo++;
            System.out.println("Annulation de la vente de billet avec succès.");
        } else {
            System.out.println("Aucun billet à annuler.");
        }
    }
    //Fin de ChatGPT


    public Evenement() {

    }

    public Evenement(String name, Lieu lieu, float price, int nbTicketsSold) {
        this.name = name;
        this.localdate = LocalDate.now();
        this.localtime = LocalTime.now();
        this.lieu = lieu;
        this.price = price;
        this.nbTicketsSold = nbTicketsSold;
        this.billetsDispo = lieu.capacity-nbTicketsSold;
    }

    public Evenement(int id, String name , Lieu lieu, float price, int nbTicketsSold) {
        this.id = id;
        this.name = name;
        this.lieu = lieu;
        this.price = price;
        this.nbTicketsSold = nbTicketsSold;
    }

    public Evenement(int id, String name, Date date, Time time, Lieu lieu, int billetsDispo, float price, int nbTicketsSold) {
        this.name = name;
        this.id = id;
        this.localdate = localdate;
        this.localtime = localtime;
        this.lieu = lieu;
        this.billetsDispo = billetsDispo;
        this.price = price;
        this.nbTicketsSold = nbTicketsSold;
    }

    @Override
    public String toString() {
        return "Evenement : " +
                "id='" + id +
                "name='" + name +
                ", localdate=" + localdate +
                ", localtime=" + localtime +
                ", lieu=" + lieu +
                ", price=" + price +
                ", nbTicketsSold=" + nbTicketsSold +
                ", nbTicketsDispo=" + billetsDispo +
                ".";
    }
}
