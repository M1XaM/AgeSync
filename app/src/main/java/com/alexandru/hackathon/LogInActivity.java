package com.alexandru.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alexandru.hackathon.api.entities.RetrofitClient;
import com.alexandru.hackathon.api.entities.logIn.LogInApiService;
import com.alexandru.hackathon.api.entities.logIn.LoginApiResponse;
import com.alexandru.hackathon.api.entities.signUp.SignUpApiResponse;
import com.alexandru.hackathon.api.entities.signUp.SignUpApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {
    Button toggleSingInLogIn;
    TextView feedbackTextView;
    Button logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        feedbackTextView = findViewById(R.id.feedback_text_view);

        logInBtn = findViewById(R.id.login_btn);
        logInBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
        });


        toggleSingInLogIn = findViewById(R.id.toggle_singin_login_btn);
        toggleSingInLogIn.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    public void logInApiCall(String login, String password){
        LogInApiService logInApiService = RetrofitClient.getClient().create(LogInApiService.class);

        Call<LoginApiResponse> call = logInApiService.postLogin(login, password);

        call.enqueue(new Callback<LoginApiResponse>() {
            @Override
            public void onResponse(Call<LoginApiResponse> call, Response<LoginApiResponse> response) {
                if(response.isSuccessful()){
                    LoginApiResponse loginApiResponse = response.body();
                    feedbackTextView.setText((Boolean)loginApiResponse.getStatus() ? "Registered(true)" : "Unregistered(flase)");
//                    if(loginApiResponse.getStatus()){

//                    }
                }else {
                    feedbackTextView.setText("Unsuccessful response: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<LoginApiResponse> call, Throwable t) {
                feedbackTextView.setText("Network error: " + t.getMessage());
            }
        });
    }
}
