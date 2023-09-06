package com.example.enrollment.enrollment.enrollTests;


import com.example.enrollment.enrollment.controller.CourseController;
import com.example.enrollment.enrollment.controller.EnrollmentController;
import com.example.enrollment.enrollment.controller.StudentController;
import com.example.enrollment.enrollment.model.Course;
import com.example.enrollment.enrollment.model.EnrollmentRequest;
import com.example.enrollment.enrollment.model.Student;
import com.example.enrollment.enrollment.service.CourseService;
import com.example.enrollment.enrollment.service.EnrollmentService;
import com.example.enrollment.enrollment.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class enrollTestClass {

    @Autowired
    private CourseController courseController;
    @Autowired
    private StudentController studentController;
    @Autowired
    private EnrollmentController enrollmentController;

    @Mock
    private StudentService studentService;
    @Mock
    private CourseService courseService;
    @Mock
    private EnrollmentService enrollmentService;

    @Test
    public void testAddStudent() {
        Student s = new Student();
        s.setName("nume2");
        when(studentService.addStudent(s)).thenReturn(s);
        ResponseEntity<Student> resp = studentController.addStudent(s);
        assertEquals(resp.getBody().getName(), "nume2");
    }

    @Test
    public void testAddCourse() {
        Course c = new Course();
        c.setTitle("title");
        when(courseService.addCourse(c)).thenReturn(c);
        ResponseEntity<Course> resp = courseController.addCourse(c);
        assertEquals(resp.getBody().getTitle(), "title");
    }

    @Test
    public void testOneCourseMultipleEnrollmentsAndOneStudentMultipleEnrollments() {
        Course c100 = new Course();
        c100.setTitle("c100");
        Course c101 = new Course();
        c101.setTitle("c101");
        Student s99 = new Student();
        s99.setName("s99");
        Student s100 = new Student();
        s100.setName("s100");
        Student s1 = studentController.addStudent(s99).getBody();
        Student s2 = studentController.addStudent(s100).getBody();
        Long idS1 = s1.getId();
        Long idS2 = s2.getId();

        Course c1 = courseController.addCourse(c100).getBody();
        Long idC1 = c1.getId();
        Course c2 = courseController.addCourse(c101).getBody();
        Long idC2 = c2.getId();

        when(enrollmentService.enrollStudentOnCourse(s1, c1)).thenReturn("Enrollment added successfully");
        when(enrollmentService.enrollStudentOnCourse(s2, c1)).thenReturn("Enrollment added successfully");
        when(enrollmentService.enrollStudentOnCourse(s1, c2)).thenReturn("Enrollment added successfully");
        when(enrollmentService.enrollStudentOnCourse(s2, c2)).thenReturn("Enrollment added successfully");

        ResponseEntity<String> res1 = enrollmentController.enrollStudentOnCourse(new EnrollmentRequest(idS1, idC1));
        ResponseEntity<String> res2 = enrollmentController.enrollStudentOnCourse(new EnrollmentRequest(idS2, idC1));
        ResponseEntity<String> res3 = enrollmentController.enrollStudentOnCourse(new EnrollmentRequest(idS1, idC2));
        ResponseEntity<String> res4 = enrollmentController.enrollStudentOnCourse(new EnrollmentRequest(idS2, idC2));
        assertEquals(res1.getBody(), "Enrollment added successfully");
        assertEquals(res2.getBody(), "Enrollment added successfully");
        assertEquals(res3.getBody(), "Enrollment added successfully");
        assertEquals(res4.getBody(), "Enrollment added successfully");
    }

}
