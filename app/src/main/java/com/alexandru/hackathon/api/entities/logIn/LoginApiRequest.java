package com.alexandru.hackathon.api.entities.logIn;

import retrofit2.http.Query;

public class LoginApiRequest {
    String login;
    String password;

    public LoginApiRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginApiRequest() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
