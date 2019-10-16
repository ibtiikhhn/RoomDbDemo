package com.codies.roomdbdemo.Repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.codies.roomdbdemo.RoomDb.BookDao;
import com.codies.roomdbdemo.RoomDb.StudentBooks;
import com.codies.roomdbdemo.RoomDb.StudentDao;
import com.codies.roomdbdemo.RoomDb.StudentDatabase;
import com.codies.roomdbdemo.RoomDb.StudentModel;

import java.util.List;

public class StudentOfflineRepo {
    private StudentDao studentDao;
    private BookDao bookDao;
    LiveData<List<StudentModel>> allStudents;
    LiveData<List<StudentBooks>> allBooks;
    LiveData<List<StudentBooks>> myBooks;

    public StudentOfflineRepo(Application application) {
        StudentDatabase studentDatabase = StudentDatabase.getStudentDatabase(application);
        studentDao = studentDatabase.studentDao();
        bookDao = studentDatabase.bookDao();
        allStudents = studentDao.getAllStudents();
        allBooks = bookDao.getAllBooks();

    }

    public void update(StudentModel studentModel) {
        new UpdateStudentAsyncTask(studentDao).execute(studentModel);
    }

    public void delete(StudentModel studentModel) {
        new DeleteStudentAsyncTask(studentDao).execute(studentModel);
    }

    public void insert(StudentModel studentModel) {
        new InsertStudentAsyncTask(studentDao).execute(studentModel);
    }

    public void deleteAllStudents() {
        new DeleteAllStudentAsyncTask(studentDao).execute();
    }

    public void insertBook(StudentBooks studentBooks) {
        new InsertBookAsyncTask(bookDao).execute(studentBooks);
    }

    public LiveData<List<StudentModel>> getAllStudents() {
        return allStudents;
    }

    public LiveData<List<StudentBooks>> getAllBooks() {
        return allBooks;
    }

  /*  public LiveData<List<StudentBooks>> getStudentBooks(int studentId) {
        return new GetStudentBooksAsyncTask(bookDao).execute(studentId);
    }*/

    public static class UpdateStudentAsyncTask extends AsyncTask<StudentModel, Void, Void> {
        StudentDao studentDao;

        public UpdateStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(StudentModel... studentModels) {
            studentDao.update(studentModels[0]);
            return null;
        }
    }

    public static class DeleteStudentAsyncTask extends AsyncTask<StudentModel, Void, Void> {
        StudentDao studentDao;

        public DeleteStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(StudentModel... studentModels) {
            studentDao.delete(studentModels[0]);
            return null;
        }
    }

    public static class InsertStudentAsyncTask extends AsyncTask<StudentModel, Void, Void> {
        StudentDao studentDao;

        public InsertStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(StudentModel... studentModels) {
            studentDao.insert(studentModels[0]);
            return null;
        }
    }

    public static class DeleteAllStudentAsyncTask extends AsyncTask<Void, Void, Void> {
        StudentDao studentDao;

        public DeleteAllStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.deleteAll();
            return null;
        }
    }

    public static class InsertBookAsyncTask extends AsyncTask<StudentBooks, Void, Void> {
        BookDao bookDao;

        public InsertBookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(StudentBooks... studentBooks) {
            bookDao.insert(studentBooks[0]);
            return null;
        }
    }

    public LiveData<List<StudentBooks>> getMyBooks(int studentId) {
        return myBooks = bookDao.getStudentBooks(studentId);
    }


   /* public static class GetStudentBooksAsyncTask extends AsyncTask<Integer, Void, List<StudentBooks>> {
        BookDao bookDao;

        public GetStudentBooksAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }


        @Override
        protected List<StudentBooks> doInBackground(Integer... integers) {

            return bookDao.getStudentBooks(integers[0]);
        }
*//*
        @Override
        protected void onPostExecute(List<StudentBooks> studentBooks) {
            super.onPostExecute(studentBooks);
        }*//*
    }

    public List<StudentBooks> returnBOOKS(List<StudentBooks> studentBooks) {
        return studentBooks;
    }*/



}

