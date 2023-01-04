package org.example;

import org.example.UI.UIMenuUsers;

public class Main {
    public static void main(String[] args) {
        try {
            UIMenuUsers.menuUsers();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}