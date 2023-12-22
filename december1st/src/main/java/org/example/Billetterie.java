package org.example;


import org.example.dao.ClientDAO;
import org.example.dao.ClientDAOImpl;

import java.util.List;
import java.util.Scanner;

public class Billetterie {
    public static void main(String[] args) {
        List<Client> clientele;
        String nom;
        String prenom;
        String mail;
        int choix;
        Client clientutile;
        Scanner scannerbionique = new Scanner(System.in);

        Lieu lieu1 = new Lieu("Parc des Sports", "2 rue de la street, 59100 Roubaix", 20389);
        Lieu lieu2 = new Lieu("Vélodrome", "233 avenue de la réussite, 59100 Roubaix", 309420);
        Lieu lieu3 = new Lieu("CAF", "124 Boulevard Gambetta, 59100 Roubaix", 1029);

        Evenement event1 = new Evenement("Tour de France", lieu1, 29.93f, 12);
        Evenement event2 = new Evenement("Concert Magic System", lieu2, 0, 1290);
        Evenement event3 = new Evenement("Conférence avec Eddy Malou", lieu3, 0, 1);

        Client client1 = new Client("Jean", "Lassalle", "jean.lassalle@gmail.com");
        Client client2 = new Client("Nassim", "Sakhri", "sakhrin4@gmail.com");
        Client client3 = new Client("Eric", "Zemmour", "lessingesdehors@expulsion.fr");

        ClientDAOImpl clientDAO = new ClientDAOImpl();

        //        Ajouter un client :
//        System.out.println("nom du client a creer :");
//        nom = scannerbionique.nextLine();
//        System.out.println("prenom du client a creer :");
//        prenom = scannerbionique.nextLine();
//        System.out.println("mail du client a creer :");
//        mail = scannerbionique.nextLine();
//        Client clientajout = new Client(prenom, nom, mail);
//        clientDAO.ajouterClient(clientajout);

//        Montrer tous les clients
//        clientele = clientDAO.obtenirTousLesClients();
//        System.out.println(clientele);

//        Montrer un client selon son id
//        clientutile = clientDAO.obtenirClientParID(2);
//        System.out.println(clientutile);

//        Changer nom, prenom, email selon l'id :
//        System.out.println("Choisissez le client dont vous voulez changer selon l'id :");
//        choix = scannerbionique.nextInt();
//        scannerbionique.nextLine();
//        clientutile = clientDAO.obtenirClientParID(choix);
//        System.out.println("nom du client a modifier :");
//        nom = scannerbionique.nextLine();
//        System.out.println("prenom du client a modifier :");
//        prenom = scannerbionique.nextLine();
//        System.out.println("mail du client a modifier :");
//        mail = scannerbionique.nextLine();
//        clientutile.setName(prenom);
//        clientutile.setLastname(nom);
//        clientutile.setEmail(mail);
//        clientDAO.mettreAJourClient(clientutile);

//        Supprimer un client selon son id:
//        System.out.println("Donne l'id du client que tu veux supprimer");
//        choix = scannerbionique.nextInt();
//        scannerbionique.nextLine();
//        clientDAO.supprimerClient(choix);

    }
}
