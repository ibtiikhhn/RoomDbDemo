package com.codies.roomdbdemo.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codies.roomdbdemo.Repo.StudentOfflineRepo;
import com.codies.roomdbdemo.RoomDb.StudentBooks;
import com.codies.roomdbdemo.RoomDb.StudentModel;

import java.util.List;

public class StudentsViewModel extends AndroidViewModel {
    StudentOfflineRepo studentOfflineRepo;
    LiveData<List<StudentModel>> studentsList;

    public StudentsViewModel(@NonNull Application application) {
        super(application);
        studentOfflineRepo = new StudentOfflineRepo(application);
        studentsList = studentOfflineRepo.getAllStudents();
    }

    public void deleteAllStudents() {
        studentOfflineRepo.deleteAllStudents();
    }

    public void insertStudent(StudentModel studentModel) {
        studentOfflineRepo.insert(studentModel);
    }

    public void insertBook(StudentBooks studentBooks) {
        studentOfflineRepo.insertBook(studentBooks);
    }

    public void updateStudent(StudentModel studentModel) {
        studentOfflineRepo.update(studentModel);
    }

    public void deleteStudent(StudentModel studentModel) {
        studentOfflineRepo.delete(studentModel);
    }

    public LiveData<List<StudentModel>> getStudentsList() {
        return studentOfflineRepo.getAllStudents();
    }

    public LiveData<List<StudentBooks>> getAllBooks() {
        return studentOfflineRepo.getAllBooks();
    }

    public LiveData<List<StudentBooks>> getStudentBooks(int id) {
        return studentOfflineRepo.getMyBooks(id);
    }

}
