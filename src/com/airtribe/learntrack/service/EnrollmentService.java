package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository repository = new EnrollmentRepository();
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(int enrollmentId, int studentId, int courseId ){

        Student student;
        Course course;

        try {
            student = studentService.getStudentById(studentId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        course = courseService.getCourseById(courseId);

        if(course == null){
            System.out.println("Course not found with id: " + courseId);
            return;
        }

        Enrollment enrollment = new Enrollment(
               enrollmentId,
               studentId,
               courseId
        );

        repository.addEnrollment(enrollment);
        System.out.println("Student enrolled successfully");
    }

    public void viewAllEnrollments(){
        List<Enrollment> enrollments = repository.getAllEnrollments();
        if(enrollments.isEmpty()){
            System.out.println("No enrollments found");
            return;
        }
        for (Enrollment e: enrollments){
            e.display();
        }
    }
}
