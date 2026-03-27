# LearnTrack - Student & Course Management System

## About the Project
LearnTrack is a console-based application developed using Core Java. I built this project to practice Java fundamentals and understand how to structure a real-world application.

The system allows basic management of students, courses, and enrollments through a menu-driven interface. The main goal was to apply concepts like OOP, collections, and exception handling in a practical way.

---

## Features

### Student Management
- Add a new student
- View all students
- Search a student using ID
- Deactivate a student instead of deleting

### Course Management
- Add a new course
- View all courses
- Deactivate a course

### Enrollment Management
- Enroll a student into a course
- View all enrollments
- Update enrollment status (ACTIVE, COMPLETED, CANCELLED)

---

## What I Learned
While working on this project, I got hands-on experience with:

- Writing clean and structured Java code
- Using classes and objects effectively
- Applying inheritance (Student extends Person)
- Encapsulation using private fields and getters/setters
- Basic polymorphism using method overriding
- Working with ArrayList for dynamic data storage
- Handling errors using try-catch and custom exceptions
- Organizing code into layers (UI, Service, Repository)

---

## Project Structure
The project is divided into multiple packages to keep the code clean and organized:

- Main.java – Entry point of the application  
- entity – Contains model classes like Student, Course, and Enrollment  
- repository – Handles in-memory data storage using ArrayList  
- service – Contains business logic  
- exception – Custom exception classes  
- util – Utility classes like IdGenerator  
- constants – Stores application constants  
- enums – Contains fixed values like EnrollmentStatus  

---

## How to Run

Compile the project:
javac src/com/airtribe/learntrack/Main.java

Run the application:
java -cp src com.airtribe.learntrack.Main

---

## Notes
- This project uses in-memory storage, so data will reset when the program is restarted  
- The focus of this project is on learning core Java concepts, not database integration  

---


![alt text](EntityRelation_Diagram.png)
## Author
Niha2048
