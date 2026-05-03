package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private CourseRepository repository = new CourseRepository();

    public void addCourse(Course course){
        repository.addCourse(course);
        System.out.println("Course added successfully");
    }

    public void viewAllCourses(){
        List<Course> courses = repository.getAllCourses();

        if(courses.isEmpty()){
            System.out.println("No courses found");
            return;
        }

        for(Course c: courses){
            c.display();
        }

    }

    public Course getCourseById(int id){
        //return repository.findById(id);
        Course course = repository.findById(id);
        if(course == null){
            throw new RuntimeException("Course not found");
        }
        return course;
    }
}
