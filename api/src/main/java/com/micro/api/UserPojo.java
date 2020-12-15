package com.micro.api;

import java.time.LocalDateTime;

public class UserPojo {


    private String name;
    private String username;
    private String email;



    public UserPojo() {

    }

    public UserPojo(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
