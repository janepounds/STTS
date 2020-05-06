package com.example.seedtrackingtracing;

public class UserInfo {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String district;
    public String village;

    public UserInfo() {

    }

    public UserInfo(String firstName, String lastName, String phoneNumber, String district, String village) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.village = village;
    }
}
