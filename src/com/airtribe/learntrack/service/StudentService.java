package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(String firstName, String lastName, String email, String batch) {

        int id = IdGenerator.getNextStudentId();

        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }

    public void deactivateStudent(int id) {
        Student student = getStudentById(id);
        student.setActive(false);
    }

    public void updateStudentEmail(int id, String newEmail) {
        Student student = getStudentById(id);
        student.setEmail(newEmail);
    }
}