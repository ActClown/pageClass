package com.syp.entity;

/**
 * Created by syp on 2017-11-21.
 * 实体类
 */
public class User {
    private int id;
    private String username;
    private String gender;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
