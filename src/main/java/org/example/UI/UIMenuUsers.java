package org.example.UI;

import org.example.Users.Model.Users;
import org.example.Users.Services.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class UIMenuUsers {
    public static void menuUsers() throws SQLException {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        int opcion;
        do {
            System.out.println("____________________\n" +
                    " Application from Users \n" +
                    " 1. Create user \n" +
                    " 2. Find users \n" +
                    " 3. Find users by id \n" +
                    " 4. Update user \n" +
                    " 5. Delete user \n" +
                    " 0. Exit \n");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    userService.save();
                    break;
                case 2:
                    System.out.println("LIST FROM USERS");
                    ArrayList<Users> users = userService.find();
                    for (Users user :
                            users) {
                        System.out.println("Name: " + user.getName());
                        System.out.println("Lastname: " + user.getLast_name());
                        System.out.println("Identification: " + user.getIdentification());
                        System.out.println("Date-birthday: " + user.getDate_birth());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("User: " + user.getUser());
                        System.out.println("Password: " + user.getPassword());
                        System.out.println("____________________");
                    }
                    break;
                case 3:
                    System.out.println("Finding user...");
                    System.out.println("Please insert user_id");
                    int user_id_find = Integer.parseInt(sc.nextLine());
                    Users user = userService.find_id(user_id_find);
                    System.out.println("____________________\n" +
                            "The User " + user.getName() + " Successfully. \n" +
                            "Lastname: " + user.getLast_name() + "\n" +
                            "Identification: " + user.getIdentification() + "\n" +
                            "Date: " + user.getDate_birth() + " \n" +
                            "Email: " + user.getEmail() + "\n" +
                            "User: " + user.getUser() + "\n" +
                            "Password: " + user.getPassword());
                    break;
                case 4:
                    System.out.println("Updating user");
                    userService.update();
                    break;
                case 5:
                    System.out.println("Deleting user...\n");
                    System.out.println("Please insert user_id");
                    int user_id = Integer.parseInt(sc.nextLine());
                    userService.delete(user_id);

                    break;
                case 0:
                    System.out.println("Thanks for visit...");
                    break;
                default:
                    System.out.println("Select one option valid");
                    break;
            }

        } while (opcion != 0);
    }
}
