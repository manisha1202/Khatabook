package com.manisha.khatabook.models;

public class User {

    private String user_name;
    private String phone_number;
    private String password;
    private String email;
    private String address;
    private String image;

    public User(){

    }
    public User(String user_name, String phone_number, String password, String email, String address, String image) {
        this.user_name = user_name;
        this.phone_number = phone_number;
        this.password = password;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
