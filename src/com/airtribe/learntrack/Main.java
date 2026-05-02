package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //to read from user
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        while (true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Deactivate Student");
            System.out.println("4. Add Course");
            System.out.println("5. View Courses");
            System.out.println("6. Enroll Student");
            System.out.println("7. View Enrollments");
            System.out.println("8. Exit");

            //int choice = sc.nextInt();//take user input
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }

          switch (choice){
               case 1:
                   //System.out.println("Enter ID : ");
                  // int id = sc.nextInt();
                   int id = IdGenerator.getNextId();
                   System.out.println("Generated ID: " + id);

                   System.out.println("Enter First Name: ");
                   String firstName = sc.next();

                   System.out.println("Enter Last Name: ");
                   String lastName = sc.next();

                   System.out.println("Enter Email: ");
                   String email = sc.next();

                   System.out.println("Enter Batch: ");
                   String batch = sc.next();

                   Student student = new Student(id, firstName, lastName, email, batch);
                   studentService.addStudent(student);
                   break;

               case 2:

                   studentService.viewAllStudents();
                   break;

              case 3:
                  System.out.print("Enter Student ID to deactivate: ");
                  int deactivateId = sc.nextInt();

                  studentService.deActivateStudent(deactivateId);
                  break;

              case 4:
                  System.out.println("Enter Course ID : ");
                  int courseId = sc.nextInt();

                  System.out.println("Enter Course Name: ");
                  String courseName  = sc.next();

                  System.out.println("Enter Description: ");
                  String description  = sc.next();

                  System.out.print("Enter Duration (weeks): ");
                  int duration = sc.nextInt();

                  Course course = new Course(courseId, courseName, description,duration);
                  courseService.addCourse(course);
                  break;

              case 5:
                  courseService.viewAllCourses();
                  break;

              case 6:
                  System.out.println("Enter Enrollment ID: ");
                  int eId = sc.nextInt();

                  System.out.println("Enter Student ID: ");
                  int sId = sc.nextInt();

                  System.out.println("Enter Course ID: ");
                  int cId = sc.nextInt();

                 enrollmentService.enrollStudent(eId, sId, cId);
                 break;

              case 7:
                  enrollmentService.viewAllEnrollments();
                  break;

              case 8:
                  System.out.println("Exiting...");
                  return;

              default:
                   System.out.println("Invalid Choice");

          }
        }
    }
}
