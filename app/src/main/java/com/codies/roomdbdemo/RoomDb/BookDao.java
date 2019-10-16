package com.codies.roomdbdemo.RoomDb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(StudentBooks studentBooks);

    @Update
    void update(StudentBooks studentBooks);

    @Delete
    void delete(StudentBooks studentBooks);

    @Query("SELECT * from books_table")
    LiveData<List<StudentBooks>> getAllBooks();

    @Query("SELECT * from books_table where studentId =:studentId")
    LiveData<List<StudentBooks>> getStudentBooks(int studentId);


}
