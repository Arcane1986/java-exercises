package com.rich.cheesemvc.User;

import java.util.HashMap;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPassword(String verify){
        return verify.equals(this.password);
    }

    public HashMap<String,String> verifyData(String verify) {
        HashMap<String,String> errors = new HashMap<>();
        if (!this.verifyPassword(verify)) {
            errors.put("verify", "PASSWORDS DO NOT MATCH");
            }
        return errors;
    }

}
