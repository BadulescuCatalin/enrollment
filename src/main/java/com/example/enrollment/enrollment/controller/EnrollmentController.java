package com.example.enrollment.enrollment.controller;

import com.example.enrollment.enrollment.exception.CourseNotFoundException;
import com.example.enrollment.enrollment.exception.StudentNotFoundException;
import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.model.Enrollment;
import com.example.enrollment.enrollment.model.EnrollmentRequest;
import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.service.CourseService;
import com.example.enrollment.enrollment.service.EnrollmentService;
import com.example.enrollment.enrollment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    private final CourseService courseService;

    @PostMapping(value = "/enroll")
    public ResponseEntity<String> enrollStudentOnCourse(@RequestBody EnrollmentRequest enrollmentRequest) {

        Long student_id = enrollmentRequest.getStudent_id();
        Long course_id = enrollmentRequest.getCourse_id();
        Optional<Student> studentToEnroll = studentService.getStudentById(student_id);
        Optional<Course> courseToEnroll = courseService.getCourseById(course_id);
        if (studentToEnroll.isEmpty()) {
            throw new StudentNotFoundException("Invalid student id");
        }
        if (courseToEnroll.isEmpty()) {
            throw new CourseNotFoundException("Invalid course id");
        }
        return ResponseEntity
                .ok()
                .body(enrollmentService.enrollStudentOnCourse(studentToEnroll.get(), courseToEnroll.get()));

    }
}
