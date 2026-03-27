package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    // Save student
    public void save(Student student) {
        students.add(student);
    }

    // Get all students
    public List<Student> findAll() {
        return students;
    }

    // Find by ID
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; // handled in service layer
    }

    public void update(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                return;
            }
        }
    }
 
    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}