package org.example;


import org.example.dao.ClientDAOImpl;

import java.util.List;

public class Billetterie {
    public static void main(String[] args) {
        List<Client> clientele;


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
//        clientDAO.ajouterClient(client2);

//Montrer tous les clients
//        clientele = clientDAO.obtenirTousLesClients();
//        System.out.println(clientele);


//        Client client0 = clientDAO.obtenirClientParEmail("tellementdechoses@dansunstring.com");
//        System.out.println(client0);

//        Changer nom et prenom selon email :
//        client2.setName("Nassimtest");
//        clientDAO.mettreAJourClient(client2);

//        Supprimer un client selon son adresse:
//clientDAO.supprimerClient("testo@tasoeur.fr");

    }
}
