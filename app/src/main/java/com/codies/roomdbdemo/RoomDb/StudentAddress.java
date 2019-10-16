package com.codies.roomdbdemo.RoomDb;

public class StudentAddress {
    public String street;
    public String state;
    public String city;

    public StudentAddress(String street, String state, String city) {
        this.city = city;
        this.state = state;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
