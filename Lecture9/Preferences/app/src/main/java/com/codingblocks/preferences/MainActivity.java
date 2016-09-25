package com.codingblocks.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSavedNumber;
    EditText etInputNumber;
    Button btnSave;
    SharedPreferences sPref;
    int bundleSavedInt = 0;

    public static final String KEY_SAVED_NUM = "saved_num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            bundleSavedInt = savedInstanceState.getInt(KEY_SAVED_NUM, 0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sPref = getPreferences(MODE_PRIVATE);
        //sPref = getSharedPreferences("PrefName", MODE_PRIVATE);



        tvSavedNumber = (TextView) findViewById(R.id.tvSavedNumber);
        etInputNumber = (EditText) findViewById(R.id.etInputNumber);
        btnSave = (Button) findViewById(R.id.btnSave);

        int savedNumber = sPref.getInt(KEY_SAVED_NUM, 0);

        tvSavedNumber.setText(String.valueOf(bundleSavedInt));
        //tvSavedNumber.setText(String.valueOf(savedNumber));


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int enteredNum = Integer.valueOf(etInputNumber.getText().toString());

                SharedPreferences.Editor sPrefEditor = sPref.edit();
                sPrefEditor.putInt(KEY_SAVED_NUM, enteredNum); //Data not written here
                sPrefEditor.apply(); // Data actually written here

                tvSavedNumber.setText(String.valueOf(enteredNum));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        if (outState != null && !etInputNumber.getText().toString().isEmpty()) {
            outState.putInt(KEY_SAVED_NUM, Integer.parseInt(etInputNumber.getText().toString()));
        }


        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
