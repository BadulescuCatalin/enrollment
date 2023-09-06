package com.example.enrollment.enrollment.service;

import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}
