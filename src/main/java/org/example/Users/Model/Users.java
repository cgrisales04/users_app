package org.example.Users.Model;


public final class Users {
    private int user_id;
    private String name;
    private String last_name;
    private String identification;
    private String date_birth;
    private String email;
    private String user;
    private String password;

    public Users(String name, String last_name, String identification, String date_birth, String email, String user, String password) {
        this.user_id++;
        this.name = name;
        this.last_name = last_name;
        this.identification = identification;
        this.date_birth = date_birth;
        this.email = email;
        this.user = user;
        this.password = password;
    }

    public Users() {

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
