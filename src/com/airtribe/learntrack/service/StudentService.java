package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private StudentRepository repository = new StudentRepository(); //object creation for the repository layer

    //Add student
    public void addStudent(Student student){
        repository.addStudent(student);
        System.out.println("Student Added Successfully");
    }

    //View All Student
    public void viewAllStudents(){
       List<Student> students =  repository.getAllStudents();

        if(students.isEmpty()){
            System.out.println("No student found");
            return;
        }

        //here I am try to use directly (.tolist) but I don't know java will support or not
        // so I used for each still I commented out and used for loop suggest me we can use atlest lamda or not?
       // students.forEach(s -> s.display());
        for(Student s : students){
            s.display();
        }

    }

    //Find by studentID
    public Student getStudentById(int id){
       Student student =  repository.findById(id);
        if(student == null){
            throw new RuntimeException("Student not found with id: " + id);
        }
        return student;
    }

    // Deactivate student
    public void deActivateStudent(int id){
        Student student = repository.findById(id);
        if(student == null){
            //System.out.println("Student not Found");
            throw new RuntimeException("Student not found");
           // return;
        }
        student.deactivate();
        System.out.println("Student Deactivated");
    }

}
