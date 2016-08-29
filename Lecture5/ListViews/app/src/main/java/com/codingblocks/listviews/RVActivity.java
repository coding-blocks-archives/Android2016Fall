package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codingblocks.listviews.model.Student;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        students = Student.getStudents();

        RecyclerView rvStudents = (RecyclerView) findViewById(R.id.rv_student_list);
        StudentListAdapter slAdapter = new StudentListAdapter();
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvStudents.setLayoutManager(lm);
        rvStudents.setAdapter(slAdapter);

    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public StudentViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAddr = (TextView) itemView.findViewById(R.id.tv_address);
            tvAge = (TextView) itemView.findViewById(R.id.tv_age);
            tvRoll = (TextView) itemView.findViewById(R.id.tv_rollno);
        }
        View rootView;
        TextView tvName;
        TextView tvAddr;
        TextView tvAge;
        TextView tvRoll;
    }


    public class StudentListAdapter extends RecyclerView.Adapter<StudentViewHolder>{

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = getLayoutInflater();
            View convertView = null;

            switch (viewType) {
                case 0:
                    convertView = li.inflate(R.layout.list_item_student, parent, false);
                    break;
                case 1:
                    convertView = li.inflate(R.layout.list_item_student2, parent, false);
                    break;
            }


            StudentViewHolder studentViewHolder = new StudentViewHolder(convertView);

            return studentViewHolder;
        }

        @Override
        public int getItemViewType(int position) {
            return (position%2);
        }



        @Override
        public void onBindViewHolder(StudentViewHolder studentViewHolder, final int position) {
            Student stu = students.get(position);
            studentViewHolder.tvName.setText(stu.getName());
            studentViewHolder.tvAddr.setText(stu.getAddress());

            studentViewHolder.tvAge.setText(String.valueOf(stu.getAge()));
            studentViewHolder.tvRoll.setText(String.valueOf(stu.getRollNo()));
            studentViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RVActivity.this, "Clicked on " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return students.size();
        }
    }
}
