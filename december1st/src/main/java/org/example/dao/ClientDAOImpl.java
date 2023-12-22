package org.example.dao;

import org.example.Client;
import org.example.utils.DatabaseManager;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    String sql;
    Connection connection;

    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Client client;
    private List<Client> clients = new ArrayList<>();

    @Override
    public void ajouterClient(Client client) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "INSERT INTO client (name, last_name, email) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastname());
            preparedStatement.setString(3, client.getEmail());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("Nombre de ligne ajoutées = " + nbrows);
            DatabaseManager.closeConnection();
        } catch (SQLException e) {
            System.out.println("nique ta grand mere");
        }


    }

    @Override
    public void mettreAJourClient(Client client) {
        connection = DatabaseManager.getConnection();
        try {
            sql = "UPDATE client SET name = ?, last_name = ?, email = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastname());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setInt(4, client.getId());
            int nbrows = preparedStatement.executeUpdate();
            System.out.println("nombre de lignes modifiées : " + nbrows);
        } catch (SQLException e) {
            System.out.println("toujours aussi nul en développement a ce que je vois.");
        }
        DatabaseManager.closeConnection();
    }

    @Override
    public void supprimerClient(int idClient) {
        connection = DatabaseManager.getConnection();
        sql = "DELETE FROM client WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idClient);
            int nbrows = preparedStatement.executeUpdate();

            System.out.println("Suppression effectuée. nombre de ligne supprimées : " + nbrows);
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
    }

    @Override
    public Client obtenirClientParID(int idClient) {
        connection = DatabaseManager.getConnection();
        client = null;
        try {
            sql = "SELECT * FROM client WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idClient);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("last_name"),
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {

        }
        DatabaseManager.closeConnection();
        return client;
    }

    @Override
    public List<Client> obtenirTousLesClients() {
        connection = DatabaseManager.getConnection();
        try {
            sql = "SELECT * FROM client";
            clients = new ArrayList<>();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                clients.add(new Client(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Labagarre");
        }
        DatabaseManager.closeConnection();
        return clients;
    }
}
