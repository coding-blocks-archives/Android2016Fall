package com.codingblocks.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codingblocks.fragments.fragments.BlueFragment;
import com.codingblocks.fragments.fragments.RedFragment;

import java.util.List;

public class DynamicFragmentActivity extends AppCompatActivity {

    int b = 0, r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        if (savedInstanceState != null) {
            b = savedInstanceState.getInt("b", 0);
            r = savedInstanceState.getInt("r", 0);
        }

        Button btnRed = (Button) findViewById(R.id.btnRed);
        Button btnBlue = (Button) findViewById(R.id.btnBlue);
        Button btnBack = (Button) findViewById(R.id.btnBack);


        final FragmentManager fragMan = getSupportFragmentManager();

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b++;
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                fragTxn.add(R.id.fragment_container, BlueFragment.newInstance(b));
                fragTxn.commit();
            }
        });
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r++;
                FragmentTransaction fragTxn = fragMan.beginTransaction();
                fragTxn.add(R.id.fragment_container, RedFragment.newInstance(r));
                fragTxn.commit();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("b", b);
        outState.putInt("r", r);

        super.onSaveInstanceState(outState);
    }
}
