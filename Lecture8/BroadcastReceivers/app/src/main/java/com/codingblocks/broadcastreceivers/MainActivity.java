package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvPowerStatus;
    RelativeLayout background;
    PowerChangedReceiver pcr;
    IntentFilter pif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPowerStatus = (TextView) findViewById(R.id.power_status);
        background = (RelativeLayout) findViewById(R.id.background);

        pcr = new PowerChangedReceiver();
        pif = new IntentFilter();
        pif.addAction(Intent.ACTION_POWER_CONNECTED);
        pif.addAction(Intent.ACTION_POWER_DISCONNECTED);


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

    public class PowerChangedReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                tvPowerStatus.setText("Connected");
                background.setBackgroundColor(Color.GREEN);
            } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                tvPowerStatus.setText("Disconnected");
                background.setBackgroundColor(Color.RED);
            }
        }
    }
}
