package org.example.dao;

import org.example.Lieu;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LieuDAOImpl implements LieuDAO {
    String sql;
    public Statement statement;
    Connection connection;
    private List<Lieu> lieux = new ArrayList<>();

    @Override
    public void ajouterLieu(Lieu lieu) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
    }

    @Override
    public void mettreAJourLieu(Lieu lieu) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
    }

    @Override
    public void supprimerLieu(String nomLieu) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
    }

    @Override
    public Lieu obtenirLieuParNom(String nomLieu) {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
        return null;
    }

    @Override
    public List<Lieu> obtenirTousLesLieus() {
        connection = DatabaseManager.getConnection();


        DatabaseManager.closeConnection();
        return new ArrayList<>(lieux);
    }
}

