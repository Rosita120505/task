package com.example.task.repository;

import com.example.task.model.dto.StudentDto;
import com.example.task.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(
            value = "SELECT new com.example.task.model.dto.StudentDto(s.studentId, s.name, s.phoneNumber, s.gender, b.title, b.category) " + "FROM Student s " + "INNER JOIN Book b ON b.bookId = s.bookId"
    )
    List<StudentDto> getAllStudents();
}
