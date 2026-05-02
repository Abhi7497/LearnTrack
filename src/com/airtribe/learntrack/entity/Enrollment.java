package com.airtribe.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {
    //Fields: id, studentId, courseId, enrollmentDate, status
    private int id;
    private int studentId;
    private  int courseId;
    private LocalDate enrollmentDate;
    private String status;


    // Full constructor
    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, String status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    // Constructor overloading
    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now(); // auto date
        this.status = "ACTIVE"; // default status
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void display(){
        System.out.println("Enrollment ID: " + id +
                ", Student ID: " + studentId +
                ", Course ID: " + courseId +
                ", Date: " + enrollmentDate +
                ", Status: " + status );

    }
}
