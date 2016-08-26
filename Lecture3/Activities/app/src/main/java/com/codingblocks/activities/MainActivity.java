package com.codingblocks.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";

    int op1, op2;
    String operator;

    public MainActivity() {
        Log.d(TAG, "MainActivity: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    public void onButtonClick(View v) {
        String buttonVar = ((Button) v).getText().toString();

        try {
            int operand = Integer.valueOf(buttonVar);
            if (operand == 1) {
                Intent i = new Intent(this, OtherActivity.class);
                startActivity(i);
                finish();
            }

        } catch (NumberFormatException nfe) {
            if (buttonVar.equals("C")) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:190"));
                i.putExtra("a", 10);
                startActivity(i);
            }

        }
    }
}
