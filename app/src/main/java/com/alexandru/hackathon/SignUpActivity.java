package com.alexandru.hackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alexandru.hackathon.api.entities.RetrofitClient;
import com.alexandru.hackathon.api.entities.signUp.SignUpApiResponse;
import com.alexandru.hackathon.api.entities.signUp.SignUpApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    Button toggleSingInLogIn;
    TextView feedbackTextView;
    Button singUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        feedbackTextView = findViewById(R.id.feedback_text_view);

        singUpBtn = findViewById(R.id.sign_up);
        singUpBtn.setOnClickListener(v -> {
            TextView login = findViewById(R.id.login);
            TextView name = findViewById(R.id.name);
            TextView password = findViewById(R.id.password);
            singInApiCall(name.getText().toString(), login.getText().toString(), password.getText().toString());
        });


        toggleSingInLogIn = findViewById(R.id.toggle_singin_login_btn);
        toggleSingInLogIn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
            startActivity(intent);
        });
    }

    public void singInApiCall(String fullName ,String login, String password){
        SignUpApiService singUpApiService = RetrofitClient.getClient().create(SignUpApiService.class);

        Call<SignUpApiResponse> call = singUpApiService.postSignUp(fullName, login, password);

        call.enqueue(new Callback<SignUpApiResponse>() {
            @Override
            public void onResponse(Call<SignUpApiResponse> call, Response<SignUpApiResponse> response) {
                if(response.isSuccessful()){
                    SignUpApiResponse signUpApiResponse = response.body();
                    feedbackTextView.setText(signUpApiResponse.getId()+ " "+ signUpApiResponse.getStatus());
                }else {
                    feedbackTextView.setText("Unsuccessful response: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<SignUpApiResponse> call, Throwable t) {
                feedbackTextView.setText("Network error: " + t.getMessage());
            }
        });
    }

//     feedbackTextView.setText(loginApiResponse.getAccess() ? "Registered(true)" : "Unregistered(flase)");
//}else {
//        feedbackTextView.setText("Unsuccessful response: " + response.raw());
//        }
//        }
//
//@Override
//public void onFailure(Call<SignUpApiResponse> call, Throwable t) {
//        feedbackTextView.setText("Network error: " + t.getMessage());
//        }
//        });

//    public void makeApiCall(String fullName,String login, String password){
//        LoginServiceApi loginServiceApi = RetrofitClient.getClient().create(LoginServiceApi.class);
//
//        LoginApiRequest loginApiRequest = new LoginApiRequest(login, password);
//
//        Call<LoginApiResponse> call = loginServiceApi.postLogin(loginApiRequest);
//
//        call.enqueue(new Callback<LoginApiResponse>() {
//            @Override
//            public void onResponse(Call<LoginApiResponse> call, Response<LoginApiResponse> response) {
//                if(response.isSuccessful()){
//                    LoginApiResponse loginApiResponse = response.body();
//                    welcomeTextView.setText(loginApiResponse.getAccess() ? "true" : "flase");
//                }else {
//
//
//                    welcomeTextView.setText("Unsuccessful response" + response.raw());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginApiResponse> call, Throwable t) {
//                welcomeTextView.setText("Network error: " + t.getMessage());
//            }
//        });



//
//        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
//        Call<SingUpApiResponse> call = apiService.signUp(fullName, login, password);
//        call.enqueue(new Callback<SingUpApiResponse>() {
//            @Override
//            public void onResponse(Call<SingUpApiResponse> call, Response<SingUpApiResponse> response) {
//                if (response.isSuccessful()) {
//                    SingUpApiResponse userResponse = response.body();
//                    welcomeTextView.setText(userResponse.getMessage() + " " + userResponse.getId());
//                } else {
//                    welcomeTextView.setText(response.raw().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SingUpApiResponse> call, Throwable t) {
//                welcomeTextView.setText("Net err:" + t.getMessage());
//            }
//        });
//    }
}