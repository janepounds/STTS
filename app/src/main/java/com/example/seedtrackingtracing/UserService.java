package com.example.seedtrackingtracing;


import com.example.seedtrackingtracing.dataobjects.DataRequest;
import com.example.seedtrackingtracing.dataobjects.User;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    //login
    @FormUrlEncoded
    @POST("api")
    Call<User> userLogin(@Field("action")String action,@Field("username")String usernme,@Field("password")String password);
    // @Headers({"accept: application/json",
    //         "Authorization: Token {token}"})
}
