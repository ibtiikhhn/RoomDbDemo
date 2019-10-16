package com.codies.roomdbdemo.RoomDb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {StudentModel.class,StudentBooks.class}, version = 5)
public abstract class StudentDatabase extends RoomDatabase {

    public static StudentDatabase studentDatabase;

    public abstract StudentDao studentDao();

    public abstract BookDao bookDao();

    public static synchronized StudentDatabase getStudentDatabase(Context context) {
        if (studentDatabase == null) {
            studentDatabase = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "studentDB")
                    .addCallback(callback)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return studentDatabase;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
//            new PopulateDatabase(studentDatabase).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
//            new PopulateDatabase(studentDatabase).execute();
        }
    };



}