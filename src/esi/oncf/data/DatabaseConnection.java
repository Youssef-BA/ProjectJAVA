/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost/oncf"                                                                      ;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
       public static Connection getConnection() throws SQLException  {
        Connection connection = null;
        try {
            // Chargement du driver JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connexion à la base de données
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement du driver JDBC : " + e.getMessage());
        }
        return connection;
    }
}
