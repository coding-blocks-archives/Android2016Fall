package com.codingblocks.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        for (Sensor sensor: sm.getSensorList(Sensor.TYPE_ALL)) {
            Log.d(TAG, "onCreate: name    :" + sensor.getName());
            Log.d(TAG, "onCreate: vendor  :" + sensor.getVendor());
            Log.d(TAG, "onCreate: version :" + sensor.getVersion());
            Log.d(TAG, "onCreate: maxRange:" + sensor.getMaximumRange());
            Log.d(TAG, "onCreate: power   :" + sensor.getPower());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                Log.d(TAG, "onCreate: type   :" + sensor.getStringType());
            }
        }

        SensorEventListener eventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.d(TAG, "onSensorChanged: " + event.accuracy);
                Log.d(TAG, "onSensorChanged: " + event.values[0]);
                Log.d(TAG, "onSensorChanged: " + event.values[1]);
                Log.d(TAG, "onSensorChanged: " + event.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sm.registerListener(eventListener,
                sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                100000);



    }
}
