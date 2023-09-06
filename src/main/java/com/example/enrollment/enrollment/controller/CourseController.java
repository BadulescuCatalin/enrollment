package com.example.enrollment.enrollment.controller;

import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping(value = "/all_courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity
                .ok()
                .body(courseService.getAllCourses());
    }

    @PostMapping(value = "/add_course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course addedCourse = courseService.addCourse(course);
        if (addedCourse != null) {
            return ResponseEntity
                    .ok()
                    .body(addedCourse);
        }
        return ResponseEntity
                .badRequest()
                .body(null);
    }
}
