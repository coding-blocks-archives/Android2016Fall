package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.codingblocks.listviews.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = Student.getStudents();

        ArrayList<String> myStrings = new ArrayList<>();
        myStrings.add("Alpha");
        myStrings.add("Beta");
        myStrings.add("Gamma");
        myStrings.add("Delta");
        myStrings.add("Sigma");
        myStrings.add("Theta");

        ListView listView = (ListView) findViewById(R.id.lv_student);
        ArrayAdapter<Student> myAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students
        );
        listView.setAdapter(myAdapter);
    }
}
