# LearnTrack - Student & Course Management System

## 📌 Project Overview
LearnTrack is a console-based application built using Core Java. It allows users to manage Students, Courses, and Enrollments through a menu-driven interface.

This project demonstrates strong fundamentals of Java including OOP principles, collections, exception handling, and clean architecture.

---

## 🚀 Features

### 👨‍🎓 Student Management
- Add new student
- View all students
- Search student by ID
- Deactivate student

### 📚 Course Management
- Add new course
- View all courses
- Deactivate course

### 📋 Enrollment Management
- Enroll student into a course
- View all enrollments
- Update enrollment status (ACTIVE, COMPLETED, CANCELLED)

---

## 🛠️ Technologies Used
- Core Java
- OOP (Encapsulation, Inheritance, Polymorphism)
- ArrayList (Collections)
- Exception Handling

---

## 📂 Project Structure
src/com/airtribe/learntrack/
│
├── Main.java
├── entity/
├── repository/
├── service/
├── exception/
├── util/
├── constants/
├── enums/

---

## ▶️ How to Run

### Compile:
javac src/com/airtribe/learntrack/Main.java

### Run:
java -cp src com.airtribe.learntrack.Main

---

## 📊 Class Diagram (Simplified)

Person
↑
Student
Course
Enrollment
StudentService → StudentRepository
CourseService → CourseRepository
EnrollmentService → EnrollmentRepository

---

## 🎯 Key Concepts Used
- Encapsulation (private fields + getters/setters)
- Inheritance (Student extends Person)
- Polymorphism (method overriding)
- Static usage (IdGenerator)
- Layered Architecture (UI → Service → Repository → Entity)

---

## 📌 Future Enhancements
- Database integration (MySQL)
- GUI (JavaFX / Web UI)

---

## 👨‍💻 Author
Niha2048
