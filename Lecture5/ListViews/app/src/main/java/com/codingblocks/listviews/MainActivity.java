package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.codingblocks.listviews.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = Student.getStudents();


        ListView listView = (ListView) findViewById(R.id.lv_student);
        StudentListAdapter slAdapter = new StudentListAdapter();
        listView.setAdapter(slAdapter);

    }

    public class StudentViewHolder {
        TextView tvName;
        TextView tvAddr;
        TextView tvAge;
        TextView tvRoll;
    }

    public class StudentListAdapter extends BaseAdapter {

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return (position%2);
        }

        @Override
        public int getCount() {
            return students.size();
        }

        @Override
        public Student getItem(int i) {
            return students.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            StudentViewHolder studentViewHolder;

            Log.d(TAG, "getView: " + position + (convertView == null));

            if (convertView == null) {
                if (position%2 == 0) {
                    convertView = li.inflate(R.layout.list_item_student, null);
                } else {
                    convertView = li.inflate(R.layout.list_item_student2, null);
                }
                studentViewHolder = new StudentViewHolder();
                studentViewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                studentViewHolder.tvAddr = (TextView) convertView.findViewById(R.id.tv_address);
                studentViewHolder.tvAge = (TextView) convertView.findViewById(R.id.tv_age);
                studentViewHolder.tvRoll = (TextView) convertView.findViewById(R.id.tv_rollno);
                convertView.setTag(studentViewHolder);
            } else {
                studentViewHolder = (StudentViewHolder) convertView.getTag();
            }

            Student stu = getItem(position);

            studentViewHolder.tvName.setText(stu.getName());
            studentViewHolder.tvAddr.setText(stu.getAddress());

            studentViewHolder.tvAge.setText(String.valueOf(stu.getAge()));
            studentViewHolder.tvRoll.setText(String.valueOf(stu.getRollNo()));

            return convertView;
        }
    }
}
