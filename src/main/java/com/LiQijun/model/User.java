package com.LiQijun.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private java.util.Date birthDate;

    public User(){

    }

    public User(int id, String username, String password, String email, String gender, Date birthDate){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.gender=gender;
        this.birthDate=birthDate;
    }

    public int getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
