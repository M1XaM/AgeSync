package com.alexandru.hackathon.api.entities.signUp;

public class SignUpApiRequest {
    String full_name;
    String login;
    String password;

    public SignUpApiRequest() {
    }

    public SignUpApiRequest(String full_name, String login, String password) {
        this.full_name = full_name;
        this.login = login;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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
