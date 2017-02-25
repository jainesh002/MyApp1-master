package com.example.radha.myapp;

/**
 * Created by radha on 2/23/2017.
 */

public class Information {

    String name, email, uname, pass , orderinfo , location, fav;

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public void setName(String name) {

        this.name = name;

    }

    public String getOrderinfo() {
        return orderinfo;
    }

    public String getLocation() {
        return location;
    }

    public void setOrderinfo(String orderinfo) {
        this.orderinfo = orderinfo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return this.uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }



}