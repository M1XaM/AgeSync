package com.alexandru.hackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.alexandru.hackathon.api.entities.RetrofitClient;
import com.alexandru.hackathon.api.entities.getEvents.Event;
import com.alexandru.hackathon.api.entities.getEvents.EventsGetApiService;
import com.alexandru.hackathon.api.entities.logIn.LogInApiService;
import com.alexandru.hackathon.api.entities.logIn.LoginApiResponse;
import com.alexandru.hackathon.api.entities.postEvents.CreateEventResponse;
import com.alexandru.hackathon.api.entities.postEvents.EventsPostApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Session extends AppCompatActivity {

    String link = "";
    ImageView imageView;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sesions);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        postEventReq();
        getEventCreate();

        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.img);

        imageView.setOnClickListener(v -> {
            openGoogleMeet();
        });
    }

    public void postEventReq(){
        EventsPostApiService eventsPostApiService = RetrofitClient.getClient().create(EventsPostApiService.class);

        Call<CreateEventResponse> call = eventsPostApiService.createEvent("ignore");

        call.enqueue(new Callback<CreateEventResponse>() {
            @Override
            public void onResponse(Call<CreateEventResponse> call, Response<CreateEventResponse> response) {
                if(response.isSuccessful()){
                    CreateEventResponse createEventResponse = response.body();

                }else {

                }
            }

            @Override
            public void onFailure(Call<CreateEventResponse> call, Throwable t) {

            }
        });
    }

    public void getEventCreate(){
        EventsGetApiService eventsGetApiService = RetrofitClient.getClient().create(EventsGetApiService.class);

        Call<List<Event>> call = eventsGetApiService.getEventList();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if(response.isSuccessful()){
                    List<Event> eventList = response.body();
                    link = eventList.get(0).getLink();

                }else {

                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    public void openGoogleMeet() {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(browserIntent);
        } catch (Exception e){

        }
    }
}
