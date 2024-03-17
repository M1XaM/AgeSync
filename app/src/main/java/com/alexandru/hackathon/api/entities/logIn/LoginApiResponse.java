package com.alexandru.hackathon.api.entities.logIn;

import com.google.gson.annotations.SerializedName;

public class LoginApiResponse {
    @SerializedName("status")
    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
