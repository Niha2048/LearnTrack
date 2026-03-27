package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    // Add student
    public void addStudent(String firstName, String lastName, String email, String batch) {

        int id = IdGenerator.getNextStudentId();

        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get by ID
    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }

    // Deactivate student (instead of delete)
    public void deactivateStudent(int id) {
        Student student = getStudentById(id);
        student.setActive(false);
    }

    // Update student email (example update method)
    public void updateStudentEmail(int id, String newEmail) {
        Student student = getStudentById(id);
        student.setEmail(newEmail);
    }
}