package com.alexandru.hackathon;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.alexandru.hackathon.api.entities.RetrofitClient;
import com.alexandru.hackathon.api.entities.getEvents.Event;
import com.alexandru.hackathon.api.entities.postEvents.CreateEventResponse;
import com.alexandru.hackathon.api.entities.postEvents.EventsPostApiService;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateFormActivity extends AppCompatActivity {
    Button startDate;
    Button endDate;
    ToggleButton evOnline;
    ToggleButton evOffline;
    Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_event);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue800));

        startDate = findViewById(R.id.start_date_btn);
        endDate = findViewById(R.id.end_date_btn);

        evOffline = findViewById(R.id.toggle_offline);
        toggleLink(false);
        evOffline.setChecked(false);
        evOffline.setOnClickListener(v -> {
            toggleLoc(evOffline.isChecked());
        });

        evOnline = findViewById(R.id.toggle_online);
        toggleLoc(false);
        evOnline.setChecked(false);
        evOnline.setOnClickListener(v -> {
            toggleLink(evOnline.isChecked());
        });


        endDate.setOnClickListener(v -> {
            showDatePickerDialog(endDate);
        });

        startDate.setOnClickListener(v -> {
            showDatePickerDialog(startDate);
        });

        createBtn = findViewById(R.id.create);
        createBtn.setOnClickListener(v -> {
            TextView tempName = findViewById(R.id.name);
            String name = tempName.getText().toString();

            String dateStart = startDate.getText().toString();
            String dateEnd = endDate.getText().toString();

            String link = "";
            TextView linkTV = findViewById(R.id.link);
            if(evOnline.isChecked())
                link = linkTV.getText().toString();

            String loc ="";
            TextView locTv = findViewById(R.id.loc);
            if(evOffline.isChecked())
                loc =locTv.getText().toString();

            EditText descET = findViewById(R.id.desc_field);
            String desc = descET.getText().toString();

            if(validateData(name,dateStart,dateEnd,desc)){
                EventsPostApiService eventsPostApiService = RetrofitClient.getClient().create(EventsPostApiService.class);
                dateStart += dateStart + "T00:00:00";
                dateEnd += dateEnd + "T00:00:00";

                String type = "";
                if (evOnline.isChecked()) type = "online";
                if(evOffline.isChecked()) type = "offline";
                if(evOffline.isChecked() && evOffline.isChecked()) type="online/offline";

                Call<CreateEventResponse> call = eventsPostApiService.createEvent("ignore");
                call.enqueue(new Callback<CreateEventResponse>() {
                    @Override
                    public void onResponse(Call<CreateEventResponse> call, Response<CreateEventResponse> response) {
                        if (response.isSuccessful()) {
                            CreateEventResponse createEventResponse = response.body();
                            Toast.makeText(CreateFormActivity.this, "Event created successfully: " + createEventResponse.getStatus(),
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(CreateFormActivity.this, "Failed to create event: " + response.message(),
                                    Toast.LENGTH_LONG).show();
                            descET.setText("Failed to create event: " + response.raw());
                        }

                    }

                    @Override
                    public void onFailure(Call<CreateEventResponse> call, Throwable t) {
                        Toast.makeText(CreateFormActivity.this, "Network error:" + t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }else {
                Toast.makeText(CreateFormActivity.this, "Eroare la completare",
                        Toast.LENGTH_LONG).show();
            }


        });
    }

    public boolean validateData(String name, String dateStart, String dateEnd, String desc){
        if(name == null || name.isEmpty()) return false;
        if(dateStart == null || dateStart.isEmpty() || dateStart.equals("Alegeti Data")) return false;
        if(dateEnd == null || dateEnd.isEmpty() || dateEnd.equals("Alegeti Data")) return false;
        if(desc == null || desc.isEmpty()) return false;
        if(!(evOffline.isChecked() || evOnline.isChecked())) return false;
        return true;
    }
    private void toggleLink(boolean isButtonChecked){
        ConstraintLayout layoutOnline = findViewById(R.id.layout_online);
        if(isButtonChecked)
            layoutOnline.setVisibility(View.VISIBLE);
        else
            layoutOnline.setVisibility(View.GONE);
    }

    private void toggleLoc(boolean isButtonChecked){
        ConstraintLayout layoutOnline = findViewById(R.id.layout_offline);
        if(isButtonChecked)
            layoutOnline.setVisibility(View.VISIBLE);
        else
            layoutOnline.setVisibility(View.GONE);
    }
    private void showDatePickerDialog(final Button button) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateFormActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        button.setText(date);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

}
