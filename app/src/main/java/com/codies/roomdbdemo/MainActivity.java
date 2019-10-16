package com.codies.roomdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.codies.roomdbdemo.RoomDb.StudentAddress;
import com.codies.roomdbdemo.RoomDb.StudentBooks;
import com.codies.roomdbdemo.RoomDb.StudentModel;
import com.codies.roomdbdemo.ViewModels.StudentsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "HELL";

    StudentsViewModel studentsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsViewModel = ViewModelProviders.of(this).get(StudentsViewModel.class);StudentAddress studentAddress = new StudentAddress("no2", "Gilgit-Baltistan", "Gilgit");


//        insertStudents();
        insertBook();
        studentsViewModel.getStudentsList().observe(this, new Observer<List<StudentModel>>() {
            @Override
            public void onChanged(List<StudentModel> studentModels) {
                Log.i(TAG, "onChanged: size of students"+studentModels.size());
              /*  for (StudentModel studentModel : studentModels) {
                    Log.i(TAG, "onChanged: students "+studentModel.getStudentId());
                }*/
            }
        });

        studentsViewModel.getAllBooks().observe(this, new Observer<List<StudentBooks>>() {
            @Override
            public void onChanged(List<StudentBooks> studentBooks) {
//                Log.i(TAG, "onChanged: size of Books " + studentBooks.size());
            }
        });

        studentsViewModel.getStudentBooks(1).observe(this, new Observer<List<StudentBooks>>() {
            @Override
            public void onChanged(List<StudentBooks> studentBooks) {
            }
        });
    }

    public void insertBook() {
        StudentBooks studentBooks = new StudentBooks("Ali", "HALEEMA", 1);
        studentsViewModel.insertBook(studentBooks);
    }

    public void insertStudents() {

        StudentAddress studentAddress = new StudentAddress("Street4", "State ABOOTABD", "ISLAMADAB");
        StudentModel model = new StudentModel("Ibti", "ibtiikhhn313@gmail.com", "300", "ali", "400",studentAddress);

        studentsViewModel.insertStudent(model);
    }
}
