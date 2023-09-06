package com.example.enrollment.enrollment.service;

import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.model.Enrollment;
import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.repository.CourseRepository;
import com.example.enrollment.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.enrollment.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public String enrollStudentOnCourse(Student student, Course course) {
        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .enrollmentDate(new Date())
                .build();
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return "Enrollment added successfully";
    }
}
