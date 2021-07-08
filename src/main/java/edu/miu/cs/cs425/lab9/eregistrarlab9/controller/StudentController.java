package edu.miu.cs.cs425.lab9.eregistrarlab9.controller;

import edu.miu.cs.cs425.lab9.eregistrarlab9.Model.Student;
import edu.miu.cs.cs425.lab9.eregistrarlab9.service.Impl.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    //Get all list
    @GetMapping(value ={"/student/list"})
    public List<Student> studentList(){
        return  studentService.getAllStudents();
    }

    // post new entry
    @PostMapping(value="/student/register")
    public Student addStudent(@Valid @RequestBody Student student){
        return  studentService.saveStudent(student);
    }

    //Edit Entry
    @PutMapping(value="/student/edit/{studentId}")
public  Student updateStudent( @Valid @RequestBody Student editedStudent,@PathVariable Long studentId){
return studentService.updateBookById(editedStudent, studentId);
}

    //Delete Entry
    @DeleteMapping(value = "/student/delete/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "delete success";
    }
    //Find ById
    @GetMapping(value ="/student/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }


}


