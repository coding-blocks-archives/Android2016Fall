package com.codingblocks.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            Log.d(TAG, "onStartCommand: " + "null");
        } else {
            Log.d(TAG, "onStartCommand: " + intent.toString());
        }

        tenSecLoop();

        return START_STICKY;
    }

    public static void tenSecLoop () {
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis() < (startTime + 10000)) {

        }
    }
}
