package com.codingblocks.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etAddress;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_name);
        etAddress = (EditText) findViewById(R.id.et_address);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String addr = etAddress.getText().toString();

        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("name", name);
        i.putExtra("addr", addr);
        startActivity(i);
    }
}
