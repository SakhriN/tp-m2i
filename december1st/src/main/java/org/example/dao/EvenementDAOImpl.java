package org.example.dao;

import org.example.Client;
import org.example.Evenement;
import org.example.utils.DatabaseManager;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAOImpl implements EvenementDAO {
    String sql;
    Connection connection;

    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Evenement evenement;
    private List<Evenement> evenements = new ArrayList<>();

    @Override
    public void ajouterEvenement(Evenement evenement) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "INSERT INTO evenement (name,lieu_id, price) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, evenement.getName());
            preparedStatement.setString(2, evenement.getLieu().getId());
            preparedStatement.setFloat(3, evenement.getPrice());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("Nombre de ligne ajoutées = " + nbrows);
            DatabaseManager.closeConnection();
        } catch (SQLException e) {
            System.out.println("nique ta grand mere");
        }


    }

    @Override
    public void mettreAJourEvenement(Evenement evenement) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "UPDATE client SET name = ?, lieu_id = ?, price = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, evenement.getName());
            preparedStatement.setString(2, evenement.getLieu().getId());
            preparedStatement.setFloat(3, evenement.getPrice());
            preparedStatement.setInt(4, evenement.getId());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("nombre de lignes modifiées : " + nbrows);
        } catch (SQLException e) {
            System.out.println("toujours aussi nul en développement a ce que je vois.");
        }
        DatabaseManager.closeConnection();
    }

    @Override
    public void supprimerEvenement(int idEvenement) {
        connection = DatabaseManager.getConnection();
        sql = "DELETE FROM evenement WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEvenement);
            int nbrows = preparedStatement.executeUpdate();

            System.out.println("Suppression effectuée. nombre de ligne supprimées : " + nbrows);
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
    }

    @Override
    public Evenement obtenirEvenementParId(int idEvenement) {
        connection = DatabaseManager.getConnection();
        evenement = null;
        try {
            sql = "SELECT * FROM evenement WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEvenement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                evenement = new Evenement(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("local_date"),
                        resultSet.getTime("local_time"),
                        resultSet.getInt("lieu_id"),
                        resultSet.getInt("billets_dispo"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("nb_tickets_sold")
                );
            }
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
        return evenement;
    }

    @Override
    public List<Evenement> obtenirTousLesEvenements() {
        connection = DatabaseManager.getConnection();
        try {
            sql = "SELECT * FROM evenement";
            evenements = new ArrayList<>();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                evenements.add(new Evenement(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("local_date"),
                        resultSet.getTime("local_time"),
                        resultSet.getInt("lieu_id"),
                        resultSet.getInt("billets_dispo"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("nb_tickets_sold")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Labagarre");
        }
        DatabaseManager.closeConnection();
        return evenements;
    }
}

