package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public class CourseService {

    private CourseRepository courseRepository = new CourseRepository();

    public void addCourse(String name, String description, int duration) {

        int id = IdGenerator.getNextCourseId();

        Course course = new Course(id, name, description, duration);
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        Course course = courseRepository.findById(id);

        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }

        return course;
    }

    public void deactivateCourse(int id) {
        Course course = getCourseById(id);
        course.setActive(false);
    }
}