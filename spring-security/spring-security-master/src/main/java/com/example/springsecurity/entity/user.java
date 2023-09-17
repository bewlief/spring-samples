package com.example.springsecurity.entity;

public class user {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswore() {
        return passwore;
    }

    public void setPasswore(String passwore) {
        this.passwore = passwore;
    }

    private int id;
    private String name;
    private String passwore;
}
