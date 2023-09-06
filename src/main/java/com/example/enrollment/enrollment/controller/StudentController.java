package com.example.enrollment.enrollment.controller;

import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/all_students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity
                .ok()
                .body(studentService.getAllStudents());
    }

    @PostMapping(value = "/add_student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        if (addedStudent != null) {
            return ResponseEntity
                    .ok()
                    .body(addedStudent);
        }
        return ResponseEntity
                .badRequest()
                .body(null);
    }

}
