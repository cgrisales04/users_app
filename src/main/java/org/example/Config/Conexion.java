package org.example.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection connection;
    private static Conexion instance;
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DATA_BASE = "users_app";

    public static Connection getConnection() {
        return connection;
    }

    private Conexion() {

    }

    public void connect_database() {
        try {
            connection = DriverManager.getConnection(
                    URL + "/" + DATA_BASE,
                    USER,
                    PASSWORD
            );
            System.out.println("Connection successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close_connection_database() throws SQLException {
        try {
            connection.close();
            System.out.println("Connection close...");
        } catch (Exception e) {
            System.out.println("Error " + e);
            connection.close();
        } finally {
            connection.close();
        }
    }

    /**
     * Implementation pattern singleton
     */

    public static Conexion getInstance() {
        if (instance == null){
            instance = new Conexion();
        }
        return instance;
    }

}
