package com.soufiane.student_api.controller;

import com.soufiane.student_api.entity.Student;
import com.soufiane.student_api.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student createStudent(
            @Valid @RequestBody Student student) {

        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {

        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(
            @PathVariable Long id) {

        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);
    }
}