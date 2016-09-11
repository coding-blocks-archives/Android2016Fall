package com.codingblocks.broadcastreceivers;

import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvPowerStatus;
    RelativeLayout background;
    IntentFilter pif;
    PowerChangedReceiver pcr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPowerStatus = (TextView) findViewById(R.id.power_status);
        background = (RelativeLayout) findViewById(R.id.background);

        pcr = new PowerChangedReceiver();
        pif = PowerChangedReceiver.getIntentFilter();

        pcr.setOnPowerChangedListener(new PowerChangedReceiver.OnPowerChangedListener() {
            @Override
            public void onPowerChanged(boolean connected) {
                if (connected) {
                    background.setBackgroundColor(Color.GREEN);
                    tvPowerStatus.setText("Connected");
                } else {
                    background.setBackgroundColor(Color.RED);
                    tvPowerStatus.setText("Disconnected");

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(pcr, pif);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(pcr);
        super.onPause();
    }
}
