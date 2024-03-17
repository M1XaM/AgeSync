package com.alexandru.hackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.alexandru.hackathon.api.entities.RetrofitClient;
import com.alexandru.hackathon.api.entities.getEvents.Event;
import com.alexandru.hackathon.api.entities.getEvents.EventsGetApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button createBtn;
    CardView zoomBtn;
    Button button;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        button = findViewById(R.id.btn_camera);

        button.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, Session.class);
            startActivity(intent);
        });
   }

}

