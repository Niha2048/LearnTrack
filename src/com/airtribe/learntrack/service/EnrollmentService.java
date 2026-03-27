package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    // Enroll student
    public void enrollStudent(int studentId, int courseId) {

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

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollments by student
    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    // Update status
    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);

        if (enrollment == null) {
            throw new RuntimeException("Enrollment not found");
        }

        enrollment.setStatus(status);
    }
}