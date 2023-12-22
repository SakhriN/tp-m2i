package org.example.dao;

import org.example.Evenement;

import java.util.List;

public interface EvenementDAO {
    void ajouterEvenement(Evenement evenement);
    void mettreAJourEvenement(Evenement evenement);
    void supprimerEvenement(int idEvenement);
    Evenement obtenirEvenementParId(int idEvenement);
    List<Evenement> obtenirTousLesEvenements();
}

