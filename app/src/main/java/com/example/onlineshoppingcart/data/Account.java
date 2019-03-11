package com.example.onlineshoppingcart.data;

public class Account {

    private String fname;
    private String lname;
    private String email;
    private String mobile;
    private String password;
    private String address;
    private String newPassword;

    public Account(String fname, String lname, String email, String mobile, String password, String address) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.address = address;
    }

    public Account(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public Account(String fname, String lname, String email, String mobile, String address) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Account(String mobile, String password, String newPassword) {
        this.mobile = mobile;
        this.password = password;
        this.newPassword = newPassword;
    }

    public Account(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
