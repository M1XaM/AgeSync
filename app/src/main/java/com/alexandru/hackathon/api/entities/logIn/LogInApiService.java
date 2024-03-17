package com.alexandru.hackathon.api.entities.logIn;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LogInApiService {
    @FormUrlEncoded
    @POST("/API/log_in")
    Call<LoginApiResponse> postLogin(
            @Field("login") String login,
            @Field("password") String password
    );
}
