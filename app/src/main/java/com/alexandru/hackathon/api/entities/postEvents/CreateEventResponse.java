package com.alexandru.hackathon.api.entities.postEvents;

import com.google.gson.annotations.SerializedName;

public class CreateEventResponse {
    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }
}
