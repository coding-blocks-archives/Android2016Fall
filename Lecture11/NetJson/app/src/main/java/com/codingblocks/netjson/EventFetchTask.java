package com.codingblocks.netjson;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by championswimmer on 01/10/16.
 */

public class EventFetchTask extends AsyncTask<String, Void, ArrayList<String>> {


    @Override
    protected ArrayList<String> doInBackground(String... params) {
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(params[0])).openConnection();
            conn.connect();

            String content = connToString(conn.getInputStream());

            ArrayList<String> eventNameList = jsonToEventArray(content);

            return eventNameList;


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    private String connToString (InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String buffer = "";

        while (buffer != null) {
            buffer = br.readLine();
            sb.append(buffer);
        }

        return sb.toString();
    }

    private ArrayList<String> jsonToEventArray (String jsonString) throws JSONException {

        ArrayList<String> eventList = new ArrayList<>();

        JSONArray jArr = new JSONArray(jsonString);
        for (int i = 0; i < jArr.length(); i++) {
            JSONObject eventObj = jArr.getJSONObject(i);
            String eventName = eventObj.getString("name");
            eventList.add(eventName);
        }
        return eventList;
    }
}
