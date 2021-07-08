package edu.miu.cs.cs425.lab9.eregistrarlab9.service.Impl;
import edu.miu.cs.cs425.lab9.eregistrarlab9.Model.Student;
import edu.miu.cs.cs425.lab9.eregistrarlab9.repository.StudentRepository;
import edu.miu.cs.cs425.lab9.eregistrarlab9.service.IStudentService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    //For Editing the student data
    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    //For Deleting student
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateBookById(Student editedStudent, Long studentId) {
        return studentRepository.findById(studentId)
                .map(bookToUpdate->{
                    bookToUpdate.setStudentNumber(editedStudent.getStudentNumber());
                    bookToUpdate.setLastName(editedStudent.getLastName());
                    bookToUpdate.setCgpa(editedStudent.getCgpa());
                    bookToUpdate.setDateOfEnrollment(editedStudent.getDateOfEnrollment());
                    bookToUpdate.setIsInternational(editedStudent.getIsInternational());
                    bookToUpdate.setMiddleName(editedStudent.getMiddleName());
                   // bookToUpdate.setFirst_name(editedStudent.getFirst_name());
                    return studentRepository.save(editedStudent);
                }).orElseGet(()->studentRepository.save(editedStudent));
    }


}

