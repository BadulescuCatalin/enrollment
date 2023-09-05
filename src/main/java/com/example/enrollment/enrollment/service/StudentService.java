package com.example.enrollment.enrollment.service;

import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

}
