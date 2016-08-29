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

        String[] randomNames = {
                "Ram", "Shyam", "Madhav"
        };
        String[] randomAddr = {
                "Pitampura", "Rohini", "Shalimar Bagh"
        };

        for (int i = 1; i <= 200; i++) {
            students.add(new Student(i, 10+((i+1)%3), randomNames[(i+2)%3], randomAddr[i%3]));
        }
        return students;
    }
}
