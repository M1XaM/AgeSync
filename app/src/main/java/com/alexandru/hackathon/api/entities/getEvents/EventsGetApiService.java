package com.alexandru.hackathon.api.entities.getEvents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsGetApiService {

    @GET("/API/get_event_list")
    Call<List<Event>> getEventList(
    );
}
