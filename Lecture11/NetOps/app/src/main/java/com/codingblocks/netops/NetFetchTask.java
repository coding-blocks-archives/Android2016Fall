package com.codingblocks.netops;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by championswimmer on 01/10/16.
 */

public class NetFetchTask extends AsyncTask<String, Void, String> {

    public static final String TAG = "NetFetch";

    @Override
    protected String doInBackground(String... params) {
        URL url = null;
        try {
            url = new URL(params[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true); // no required, true default

            urlConnection.connect(); // this is time consuming

            if (urlConnection.getResponseCode() == 200 ) {
                InputStream is = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();
                String buffer = "";
                while (buffer != null) {
                    buffer = br.readLine();
                    sb.append(buffer);
                }
                return sb.toString();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + s);
    }
}
