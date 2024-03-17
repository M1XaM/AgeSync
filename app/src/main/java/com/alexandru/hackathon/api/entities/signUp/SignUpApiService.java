package com.alexandru.hackathon.api.entities.signUp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignUpApiService {
    @FormUrlEncoded
    @POST("/API/sign_up")
    Call<SignUpApiResponse> postSignUp(
            @Field("full_name") String fullName,
            @Field("login") String login,
            @Field("password") String password
    );
}
