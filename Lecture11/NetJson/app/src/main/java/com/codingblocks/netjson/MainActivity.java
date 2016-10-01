package com.codingblocks.netjson;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEvents = (ListView) findViewById(R.id.lv_events);


        if (checkInternet()) {
            new EventFetchTask() {
                @Override
                protected void onPostExecute(ArrayList<String> strings) {
                    super.onPostExecute(strings);
                    ArrayAdapter<String> simpleAdapter =
                            new ArrayAdapter<String>(
                                    MainActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    android.R.id.text1,
                                    strings
                            );
                    lvEvents.setAdapter(simpleAdapter);
                }
            }.execute("http://open-event-dev.herokuapp.com/api/v2/events");
        }
    }

    public boolean checkInternet () {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()) {
            return true;
        }


        return false;
    }
}
