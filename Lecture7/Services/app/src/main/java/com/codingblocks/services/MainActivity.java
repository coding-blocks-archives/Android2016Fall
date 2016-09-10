package com.codingblocks.services;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton, serviceButton;
    Button cbServiceButton10, cbServiceButton5, cbServiceButtonNO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.button);
        serviceButton = (Button) findViewById(R.id.btnService);
        cbServiceButton5 = (Button) findViewById(R.id.btnCbService5);
        cbServiceButton10 = (Button) findViewById(R.id.btnCbService10);
        cbServiceButtonNO = (Button) findViewById(R.id.btnCbServiceNO);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenSecLoop();
            }
        });

        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyService.class);
                startService(i);
            }
        });

        cbServiceButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBIntentService.startLoopAction(5, MainActivity.this);
            }
        });
        cbServiceButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBIntentService.startLoopAction(10, MainActivity.this);
            }
        });
        cbServiceButtonNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CBIntentService.startNoLoopAction(MainActivity.this);

            }
        });

    }

    public void tenSecLoop () {
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis() < (startTime + 10000)) {

        }
    }
}
