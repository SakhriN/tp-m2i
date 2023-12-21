package org.example.dao;

import org.example.Client;
import java.util.List;

public interface ClientDAO {

    void ajouterClient(Client client);
    void mettreAJourClient(Client client);
    void supprimerClient(String emailClient);
    Client obtenirClientParEmail(String emailClient);
    List<Client> obtenirTousLesClients();
}
