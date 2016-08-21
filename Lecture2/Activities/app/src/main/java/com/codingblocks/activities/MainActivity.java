package com.codingblocks.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    public static final String TAG = "MainAct";

    TextView tvResult;
    EditText etOp1, etOp2;
    Button btnAdd, btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOp1 = (EditText) findViewById(R.id.op1);
        etOp2 = (EditText) findViewById(R.id.op2);
        btnAdd = (Button) findViewById(R.id.add);
        btnSub = (Button) findViewById(R.id.sub);
        tvResult = (TextView) findViewById(R.id.result);


        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int a = Integer.valueOf(etOp1.getText().toString());
        int b = Integer.valueOf(etOp2.getText().toString());
        int c = 0;

        switch(v.getId()) {
            case R.id.add:
                c = a + b;
                break;
            case R.id.sub:
                c = a - b;
                break;
        }


        tvResult.setText(String.valueOf(c));
    }
}
