package org.example.Users.ABC;

import org.example.Users.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IUsers {
    void save(Users usersDAO) throws SQLException;

    ResultSet find() throws SQLException;

    ResultSet find_id(int user_id) throws SQLException;

    int delete(int user_id) throws SQLException;

    int update(Users usersDAO) throws SQLException;
}
