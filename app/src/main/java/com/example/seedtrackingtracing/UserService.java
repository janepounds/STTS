package com.example.seedtrackingtracing;


import com.example.seedtrackingtracing.dataobjects.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    //login
    @POST("login")
    Call<User> userLogin(@Body User user);
    // @Headers({"accept: application/json",
    //         "Authorization: Token {token}"})
}
