package edu.miu.cs.cs425.lab9.eregistrarlab9.repository;

import edu.miu.cs.cs425.lab9.eregistrarlab9.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //List<Student> findByStudentNumberLike(String keyword);

}
