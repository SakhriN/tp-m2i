package org.example.dao;

import org.example.Evenement;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAOImpl implements EvenementDAO {
    String sql;
    Connection connection;
    private List<Evenement> evenements = new ArrayList<>();
    @Override
    public void ajouterEvenement(Evenement evenement) {
        evenements.add(evenement);
    }

    @Override
    public void mettreAJourEvenement(Evenement evenement) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
    }

    @Override
    public void supprimerEvenement(String nomEvenement) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
    }

    @Override
    public Evenement obtenirEvenementParNom(String nomEvenement) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
        return null;
    }

    @Override
    public List<Evenement> obtenirTousLesEvenements() {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
        return new ArrayList<>(evenements);
    }
}

