package org.example.dao;

import org.example.Evenement;
import org.example.Lieu;
import org.example.utils.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LieuDAOImpl implements LieuDAO {
    String sql;
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Lieu lieu;
    private List<Lieu> lieux = new ArrayList<>();

    @Override
    public void ajouterLieu(Lieu lieu) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "INSERT INTO lieu (name,address, capacity) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, lieu.getName());
            preparedStatement.setString(2, lieu.getAddress());
            preparedStatement.setFloat(3, lieu.getCapacity());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("Nombre de ligne ajoutées = " + nbrows);
            DatabaseManager.closeConnection();
        } catch (SQLException e) {
            System.out.println("nique ta grand mere");
        }


    }

    @Override
    public void mettreAJourLieu(Lieu lieu) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "UPDATE lieu SET name = ?, address = ?, capacity = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lieu.getName());
            preparedStatement.setString(2, lieu.getAddress());
            preparedStatement.setFloat(3, lieu.getCapacity());
            preparedStatement.setInt(4, lieu.getId());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("nombre de lignes modifiées : " + nbrows);
        } catch (SQLException e) {
            System.out.println("toujours aussi nul en développement a ce que je vois.");
        }
        DatabaseManager.closeConnection();
    }

    @Override
    public void supprimerLieu(int idLieu) {
        connection = DatabaseManager.getConnection();
        sql = "DELETE FROM evenement WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idLieu);
            int nbrows = preparedStatement.executeUpdate();

            System.out.println("Suppression effectuée. nombre de ligne supprimées : " + nbrows);
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
    }

    @Override
    public Lieu obtenirLieuParId(int idLieu) {
        connection = DatabaseManager.getConnection();
        lieu = null;
        try {
            sql = "SELECT * FROM lieu WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idLieu);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lieu = new Lieu(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                );
            }
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
        return lieu;
    }

    @Override
    public List<Lieu> obtenirTousLesLieux() {
        connection = DatabaseManager.getConnection();
        try {
            sql = "SELECT * FROM lieu";
            lieux = new ArrayList<>();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                lieux.add( new Lieu(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getInt("capacity")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Labagarre");
        }
        DatabaseManager.closeConnection();
        return lieux;
    }
}

