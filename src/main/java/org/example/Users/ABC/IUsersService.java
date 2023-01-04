package org.example.Users.ABC;


import org.example.Users.Model.Users;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IUsersService {
    void save() throws ParseException, SQLException;

    ArrayList<Users> find() throws SQLException;

    Users find_id(int user_id) throws SQLException;

    boolean delete(int user_id) throws SQLException;

    void update() throws SQLException;
}
