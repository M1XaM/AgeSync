package com.alexandru.hackathon.api.entities.postEvents;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsPostApiService {
    @FormUrlEncoded
    @POST("/API/create_event")
    Call<CreateEventResponse> createEvent(
        @Field("ignore") String ignore
    );
}
