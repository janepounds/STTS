package com.example.seedtrackingtracing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    //login
    @GET("Login/{Username}/{Password}")
    Call login(@Path("Username") String Username, @Path("Password") String Password);
}
