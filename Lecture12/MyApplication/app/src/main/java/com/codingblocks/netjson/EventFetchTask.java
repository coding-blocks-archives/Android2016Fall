package com.codingblocks.netjson;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by championswimmer on 02/10/16.
 */

public class EventFetchTask extends AsyncTask<String, Void, ArrayList<Event>> {


    private ArrayList<Event> jsonStringToEventList(String json) throws JSONException {
        ArrayList<Event> eventList = new ArrayList<>();

        JSONArray jArr = new JSONArray(json);
        for (int i = 0; i < jArr.length(); i++) {
            JSONObject eventObj = jArr.getJSONObject(i);

            new Event(
                    eventObj.getString("name"),
                    eventObj.getString("start_time"),
                    eventObj.getString("end_time"),
                    eventObj.getString("location_name")
            );
        }

        return eventList;
    }


    @Override
    protected ArrayList<Event> doInBackground(String... params) {

        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(params[0])).openConnection();
            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String buffer = "";

            while (buffer != null) {
                buffer = br.readLine();
                sb.append(buffer);

            }

            return jsonStringToEventList(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}

