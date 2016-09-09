package com.codingblocks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayList<Integer> intArray = new ArrayList<>();

        Toast.makeText(MainActivity.this, "New Toast", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < 100; i++) {
            intArray.add(i);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                intArray
        );
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Clicked on" + i,
                        Toast.LENGTH_SHORT).show();
                intArray.set(i, intArray.get(i) + 1);
                ((TextView) view).setText(String.valueOf(intArray.get(i)));
            }
        });
    }


}
