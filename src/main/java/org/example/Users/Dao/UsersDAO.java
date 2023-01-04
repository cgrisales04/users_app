package org.example.Users.Dao;

import org.example.Config.Conexion;
import org.example.Users.ABC.IUsers;
import org.example.Users.Model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO implements IUsers {
    private final Conexion connection =  Conexion.getInstance();

    public Conexion getConnection() {
        return connection;
    }

    @Override
    public void save(Users usersDAO) throws SQLException {
        try {
            this.connection.connect_database();
            PreparedStatement preparedStatement = Conexion.getConnection().prepareStatement(
                    "INSERT INTO users " +
                            "(`name`, `last_name`, `identification`, `date_birth`, `email`, `user`, `password`) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?);"
            );
            preparedStatement.setString(1, usersDAO.getName());
            preparedStatement.setString(2, usersDAO.getLast_name());
            preparedStatement.setString(3, usersDAO.getIdentification());
            preparedStatement.setString(4, usersDAO.getDate_birth());
            preparedStatement.setString(5, usersDAO.getEmail());
            preparedStatement.setString(6, usersDAO.getUser());
            preparedStatement.setString(7, usersDAO.getPassword());
            preparedStatement.executeUpdate();
            this.connection.close_connection_database();
        } catch (SQLException e) {
            System.out.println(e);
            this.connection.close_connection_database();
        }
    }

    @Override
    public ResultSet find() throws SQLException {
        try {
            this.connection.connect_database();
            PreparedStatement preparedStatement = Conexion.getConnection().prepareStatement("SELECT * FROM users");
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            this.connection.close_connection_database();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet find_id(int user_id) throws SQLException {
        try {
            this.connection.connect_database();

            PreparedStatement preparedStatement = Conexion.getConnection()
                    .prepareStatement("SELECT * FROM users WHERE user_id=?");
            preparedStatement.setInt(1, user_id);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error in execute:"
                    + e.getErrorCode() + " " + e.getMessage());
            this.connection.close_connection_database();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(int user_id) throws SQLException {
        try {
            this.connection.connect_database();
            PreparedStatement preparedStatement = Conexion.getConnection()
                    .prepareStatement("DELETE FROM users WHERE user_id=?");
            preparedStatement.setInt(1, user_id);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en la ejecución:"
                    + e.getErrorCode() + " " + e.getMessage());
            this.connection.close_connection_database();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Users usersDAO) throws SQLException {
        try {
            this.connection.connect_database();
            PreparedStatement preparedStatement = Conexion.getConnection().prepareStatement(
                    "UPDATE users " +
                            "SET name=?, last_name=?, identification=?, " +
                            "date_birth=?, email=?, user=?, password=? " +
                            "WHERE user_id=?");
            preparedStatement.setString(1, usersDAO.getName());
            preparedStatement.setString(2, usersDAO.getLast_name());
            preparedStatement.setString(3, usersDAO.getIdentification());
            preparedStatement.setString(4, usersDAO.getDate_birth());
            preparedStatement.setString(5, usersDAO.getEmail());
            preparedStatement.setString(6, usersDAO.getUser());
            preparedStatement.setString(7, usersDAO.getPassword());
            preparedStatement.setInt(8, usersDAO.getUser_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            this.connection.close_connection_database();
            throw new RuntimeException();
        }
    }
}
