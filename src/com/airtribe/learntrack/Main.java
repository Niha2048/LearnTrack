package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.entity.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {

        System.out.println("===== LearnTrack System Started =====");

        while (true) {
            try {
                showMainMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case MenuOptions.STUDENT_MENU:
                        handleStudentMenu();
                        break;

                    case MenuOptions.COURSE_MENU:
                        handleCourseMenu();
                        break;

                    case MenuOptions.ENROLLMENT_MENU:
                        handleEnrollmentMenu();
                        break;

                    case MenuOptions.EXIT:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid option!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ================= MAIN MENU =================
    private static void showMainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // ================= STUDENT MENU =================
    private static void handleStudentMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("11. Add Student");
        System.out.println("12. View Students");
        System.out.println("13. Search Student by ID");
        System.out.println("14. Deactivate Student");

        int choice = Integer.parseInt(scanner.nextLine());

        try {
            switch (choice) {

                case MenuOptions.ADD_STUDENT:
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Batch: ");
                    String batch = scanner.nextLine();

                    studentService.addStudent(firstName, lastName, email, batch);
                    System.out.println("Student added successfully!");
                    break;

                case MenuOptions.VIEW_STUDENTS:
                    List<Student> students = studentService.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s.getId() + " - " + s.getDisplayName());
                    }
                    break;

                case MenuOptions.SEARCH_STUDENT:
                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Student student = studentService.getStudentById(id);
                    System.out.println(student.getDisplayName());
                    break;

                case MenuOptions.DEACTIVATE_STUDENT:
                    System.out.print("Enter Student ID: ");
                    int deactivateId = Integer.parseInt(scanner.nextLine());
                    studentService.deactivateStudent(deactivateId);
                    System.out.println("Student deactivated!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= COURSE MENU =================
    private static void handleCourseMenu() {
        System.out.println("\n--- Course Menu ---");
        System.out.println("21. Add Course");
        System.out.println("22. View Courses");
        System.out.println("23. Deactivate Course");

        int choice = Integer.parseInt(scanner.nextLine());

        try {
            switch (choice) {

                case MenuOptions.ADD_COURSE:
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Duration (weeks): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    courseService.addCourse(name, desc, duration);
                    System.out.println("Course added!");
                    break;

                case MenuOptions.VIEW_COURSES:
                    List<Course> courses = courseService.getAllCourses();
                    for (Course c : courses) {
                        System.out.println(c.getId() + " - " + c.getCourseName());
                    }
                    break;

                case MenuOptions.DEACTIVATE_COURSE:
                    System.out.print("Enter Course ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    courseService.deactivateCourse(id);
                    System.out.println("Course deactivated!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= ENROLLMENT MENU =================
    private static void handleEnrollmentMenu() {
        System.out.println("\n--- Enrollment Menu ---");
        System.out.println("31. Enroll Student");
        System.out.println("32. View Enrollments");
        System.out.println("33. Update Enrollment Status");

        int choice = Integer.parseInt(scanner.nextLine());

        try {
            switch (choice) {

                case MenuOptions.ENROLL_STUDENT:
                    System.out.print("Student ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Course ID: ");
                    int courseId = Integer.parseInt(scanner.nextLine());

                    enrollmentService.enrollStudent(studentId, courseId);
                    System.out.println("Student enrolled!");
                    break;

                case MenuOptions.VIEW_ENROLLMENTS:
                    List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
                    for (Enrollment e : enrollments) {
                        System.out.println(
                                "ID: " + e.getId() +
                                ", Student: " + e.getStudentId() +
                                ", Course: " + e.getCourseId() +
                                ", Status: " + e.getStatus()
                        );
                    }
                    break;

                case MenuOptions.UPDATE_ENROLLMENT_STATUS:
                    System.out.print("Enrollment ID: ");
                    int enrollId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Status (ACTIVE/COMPLETED/CANCELLED): ");
                    String statusInput = scanner.nextLine();

                    EnrollmentStatus status = EnrollmentStatus.valueOf(statusInput.toUpperCase());

                    enrollmentService.updateEnrollmentStatus(enrollId, status);
                    System.out.println("Status updated!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}