package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseManager {
    private static final String URI = "jdbc:mysql://localhost:3306/bddbilletterie";
    private static final String USER = "root";
    private static final String PASSWORD = "test";
    private static Connection connection;



    private DatabaseManager(){

    }
    public static Connection getConnection()  {
        if (connection == null){
            System.out.println("Création d'une connection de fou furieux");
            try {
                connection = DriverManager.getConnection(URI,USER,PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Excusez moi, je pue la défaite en tant que développeur.");
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            System.out.println("Fermeture de la connection");
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("C'était une blague on va pas juste fermer la co, mais éclater le code.");
            }
            finally {
                connection = null; // Remet la connection à null aprés la fermeture
            }
        }
    }

}
