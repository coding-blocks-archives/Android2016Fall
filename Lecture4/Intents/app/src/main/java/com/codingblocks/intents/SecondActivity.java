package com.codingblocks.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Intent gotIntent;
    String name, addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gotIntent = getIntent();
        name = gotIntent.getStringExtra("name");
        addr = gotIntent.getStringExtra("addr");

        ((TextView) findViewById(R.id.tv_name_val)).setText(name);
        ((TextView) findViewById(R.id.tv_addr_val)).setText(addr);
    }
}
