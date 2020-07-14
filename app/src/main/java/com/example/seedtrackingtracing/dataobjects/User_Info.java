package com.example.seedtrackingtracing.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User_Info {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("profile_pic")
    @Expose
    private String profile_pic;

    @SerializedName("partner")
    @Expose
    private Integer partner;



    public Integer getId(){
        return  id;
    }

    public void setId(Integer id){
        this.id= id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public  void  setPhone(String phone)
    {
        this.phone = phone;


    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email =email;
    }

    public String getProfile_pic(){
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic){
        this.profile_pic = profile_pic;
    }

    public Integer getPartner(){
        return partner;
    }

    public  void setPartner(Integer partner){
        this.partner = partner;
    }
}
