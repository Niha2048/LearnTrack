package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    private StudentService studentService ;
    private CourseService courseService ;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
    this.studentService = studentService;
    this.courseService = courseService;
}

    public void enrollStudent(int studentId, int courseId) {
    
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        if (!student.isActive()) {
            throw new RuntimeException("Cannot enroll: Student is inactive");
        }

        if (!course.isActive()) {
            throw new RuntimeException("Cannot enroll: Course is inactive");
        }

        int id = IdGenerator.getNextEnrollmentId();

        Enrollment enrollment = new Enrollment(
                id,
                studentId,
                courseId,
                java.time.LocalDate.now().toString(),
                EnrollmentStatus.ACTIVE
        );

        enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);

        if (enrollment == null) {
            throw new RuntimeException("Enrollment not found");
        }

        enrollment.setStatus(status);
    }
}