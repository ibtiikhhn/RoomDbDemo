package com.codies.roomdbdemo.RoomDb;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class StudentModel {

    @PrimaryKey(autoGenerate = true)
    int studentId;

    String name;

    String email;

    String degree;

    String department;


    String bytes;

    @Embedded public StudentAddress studentAddress;

    public StudentModel(String name, String email, String degree, String department, String bytes, StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
        this.name = name;
        this.email = email;
        this.degree = degree;
        this.department = department;
        this.bytes = bytes;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public String getDegree() {
        return degree;
    }

    public String getDepartment() {
        return department;
    }


    public String getBytes() {
        return bytes;
    }
}