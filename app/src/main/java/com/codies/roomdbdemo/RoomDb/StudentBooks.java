package com.codies.roomdbdemo.RoomDb;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "books_table",
        foreignKeys = @ForeignKey(entity = StudentModel.class,
        parentColumns = "studentId",
        childColumns = "bookId",
        onDelete = CASCADE))

public class StudentBooks {
    @PrimaryKey(autoGenerate = true)
    int bookId;
    String bookArthur;
    String bookName;
    int studentId;

    public StudentBooks(String bookArthur, String bookName, int studentId) {
        this.bookArthur = bookArthur;
        this.bookName = bookName;
        this.studentId = studentId;
    }

    public String getBookArthur() {
        return bookArthur;
    }

    public String getBookName() {
        return bookName;
    }
}
