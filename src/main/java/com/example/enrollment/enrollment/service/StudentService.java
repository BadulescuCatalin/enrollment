package com.example.enrollment.enrollment.service;

import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
