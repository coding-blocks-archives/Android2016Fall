package com.codingblocks.retrofit.api;

import com.codingblocks.retrofit.model.Event;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by championswimmer on 02/10/16.
 */

public interface EventApi {

    @GET("events")
    Call<ArrayList<Event>> listEvents();

    @GET("events/{id}/event")
    Call<Event> getEventDetails(@Path("id") int id);



}
