package com.example.seedtrackingtracing.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {


        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("expiry")
        @Expose
        private String expiry;
        @SerializedName("user_info")
        @Expose
        private String user_info [];

        public User(String action,String username, String password) {
        }


        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {

        }

        public String getToken() {
            return token;
        }

        public void setToken() {


        }

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {


        }

        public String[] getUser_info() {
            return user_info;
        }

        public void setUser_info(String user_info[]) {

        }
    }


