package com.example.seedtrackingtracing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

   String BASE_URL ="https://stts.8technologies.net/api" ;

   //login
   @GET("Login/{Username}/{Password}")
   Call login(@Path("Username") String Username, @Path("Password") String Password);


}
