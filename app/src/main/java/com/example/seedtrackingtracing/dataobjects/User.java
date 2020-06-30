package com.example.seedtrackingtracing.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;



    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getFirstname(){
        return  firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;

    }

    public String getLastname(){

        return lastname;
    }

    public void  setLastname(String lastname){
        this.lastname = lastname;
    }

}
