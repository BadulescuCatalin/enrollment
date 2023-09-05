package com.example.enrollment.enrollment.service;

import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
