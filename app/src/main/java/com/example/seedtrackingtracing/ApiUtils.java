package com.example.seedtrackingtracing;

public class ApiUtils {
    public static final String BASE_URL = "https://stts.8technologies.net/api";

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
