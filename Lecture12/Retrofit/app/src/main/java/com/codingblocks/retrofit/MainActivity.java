package com.codingblocks.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codingblocks.retrofit.api.EventApi;
import com.codingblocks.retrofit.model.Event;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Event> eventList;

    public static final String TAG = "MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit =
                new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://open-event-dev.herokuapp.com/api/v2/")
                        .build();

        EventApi eventApi = retrofit.create(EventApi.class);



        eventApi.listEvents().enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                Log.d(TAG, "onResponse: ");
                Log.d(TAG, "onResponse: " + response.body().get(0).getName());
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {

            }
        });

        eventApi.getEventDetails(192).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                Log.d(TAG, "onResponse: " + response.body().getName());
                Log.d(TAG, "onResponse: " + response.body().getEnd_time());
                Log.d(TAG, "onResponse: " + response.body().getStart_time());
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });


    }
}
