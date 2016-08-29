package com.codingblocks.listviews.model;

import java.util.ArrayList;

/**
 * Created by championswimmer on 27/08/16.
 */
public class Student {

    int age;
    int rollNo;
    String name;
    String address;

    public Student(int age, int rollNo, String name, String address) {
        this.age = age;
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n";
    }

    public static ArrayList<Student> getStudents () {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(10, 1, "Ram", "Pitampura"));
        students.add(new Student(10, 2, "Shyam", "Rohini"));
        students.add(new Student(11, 3, "Madhav", "Kohat"));
        students.add(new Student(10, 4, "Ram", "Pitampura"));
        students.add(new Student(12, 5, "Ram", "Pitampura"));
        students.add(new Student(10, 6, "Ram", "Pitampura"));
        students.add(new Student(11, 7, "Ram", "Pitampura"));
        students.add(new Student(10, 8, "Ram", "Pitampura"));


        return students;
    }
}
