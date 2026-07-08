package com.soufiane.student_api.service;

import com.soufiane.student_api.entity.Student;
import com.soufiane.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl
        implements StudentService {


    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
