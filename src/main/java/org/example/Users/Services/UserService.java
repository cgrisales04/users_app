package org.example.Users.Services;

import org.example.Users.ABC.IUsersService;
import org.example.Users.Model.Users;
import org.example.Users.Dao.UsersDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService implements IUsersService {
    private final Scanner sc = new Scanner(System.in);
    private final UsersDAO usersDAO = new UsersDAO();
    private final Users user = new Users();

    @Override
    public void save() throws SQLException {
        usersDAO.save(set_info_user());
        System.out.println("User create with successfully");
    }

    @Override
    public ArrayList<Users> find() throws SQLException {
        ArrayList<Users> usersArrayList = new ArrayList<>();
        ResultSet resultSetUsers = usersDAO.find();
        while (resultSetUsers.next()) {
            Users new_user = new Users(
                    resultSetUsers.getString("name"),
                    resultSetUsers.getString("last_name"),
                    resultSetUsers.getString("identification"),
                    resultSetUsers.getString("date_birth"),
                    resultSetUsers.getString("email"),
                    resultSetUsers.getString("user"),
                    resultSetUsers.getString("password")
            );
            usersArrayList.add(new_user);
        }
        usersDAO.getConnection().close_connection_database();
        return usersArrayList;
    }

    @Override
    public Users find_id(int user_id) throws SQLException {
        try (ResultSet resultSetUser = new UsersDAO().find_id(user_id)) {
            usersDAO.getConnection().close_connection_database();
            if (resultSetUser.next()) {
                System.out.println("User selected with successfully \n");
                return new Users(resultSetUser.getString("name"),
                        resultSetUser.getString("last_name"),
                        resultSetUser.getString("identification"),
                        resultSetUser.getString("date_birth"),
                        resultSetUser.getString("email"),
                        resultSetUser.getString("user"),
                        resultSetUser.getString("password"));
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return new Users();
    }

    @Override
    public boolean delete(int user_id) throws SQLException {
        if (usersDAO.delete(user_id) != 0) {
            System.out.println("User has been deleted successfully");
            return true;
        }
        System.out.println("User does not have been deleted");
        return false;
    }

    @Override
    public void update() throws SQLException {
        ResultSet resultSetUser = new UsersDAO().find_id(user.getUser_id());
        try (resultSetUser) {
            if (resultSetUser.next()) {
                user.setName(resultSetUser.getString("name"));
                user.setName(resultSetUser.getString("last_name"));
                user.setName(resultSetUser.getString("identification"));
                user.setName(resultSetUser.getString("date_birth"));
                user.setName(resultSetUser.getString("email"));
                user.setName(resultSetUser.getString("user"));
                user.setName(resultSetUser.getString("password"));
                usersDAO.update(set_info_user());
                System.out.println("User update with successfully");

            }
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    private Users set_info_user() {
        System.out.println("Write your name...");
        user.setName(sc.nextLine());

        System.out.println("Write your lastname...");
        user.setLast_name(sc.nextLine());

        System.out.println("Write your identification...");
        user.setIdentification(sc.nextLine());

        System.out.println("Write your Date...");
        user.setDate_birth(sc.nextLine());

        System.out.println("Write your Email...");
        user.setEmail(sc.nextLine());

        System.out.println("Write your User...");
        user.setUser(sc.nextLine());

        System.out.println("Write your Password...");
        user.setPassword(sc.nextLine());

        return user;
    }
}
