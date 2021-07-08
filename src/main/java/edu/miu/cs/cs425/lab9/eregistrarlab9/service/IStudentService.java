package edu.miu.cs.cs425.lab9.eregistrarlab9.service;

import edu.miu.cs.cs425.lab9.eregistrarlab9.Model.Student;

import java.awt.print.Book;
import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    public abstract Student saveStudent(Student s);
    //For Edit the student data
    Student getStudentById(Long studentId);

    //for deleting student
    void deleteStudentById(Long studentId);

   Student updateBookById(Student editedStudent,Long studentId);

}
