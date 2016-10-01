package com.codingblocks.netops;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";
    Button btnCheckInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NetFetchTask nft = new NetFetchTask();
//        nft.execute("http://google.com");

        ((Button) findViewById(R.id.btnCheckInternet))
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternet();
            }
        });

    }


    public boolean checkInternet () {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()) {
            return true;
        }
//        Log.d(TAG, "checkInternet: typeName" + ni.getTypeName());
//        Log.d(TAG, "checkInternet: state(toString)" + ni.getState().toString());
//        Log.d(TAG, "checkInternet: extraInfo" + ni.getExtraInfo());
//        Log.d(TAG, "checkInternet: subtypeName" + ni.getSubtypeName());
        return false;
    }
}
