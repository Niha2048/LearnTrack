# Design Notes - LearnTrack

## 1. Why ArrayList instead of Array?
ArrayList is dynamic in size, making it suitable for managing data like students and courses where the number of entries is not fixed.


## 2. Where Static is Used and Why
Static is used in IdGenerator class to maintain shared counters for IDs across the application. This ensures unique IDs without creating multiple instances.


## 3. Use of Inheritance
The Student class extends the Person class to reuse common fields such as id, name, and email. This reduces code duplication and improves maintainability.


## 4. Layered Architecture
The project follows a clean layered architecture:

UI Layer (Main.java)  
↓  
Service Layer (Business Logic)  
↓  
Repository Layer (Data Storage)  
↓  
Entity Layer (Models)

This separation improves readability, maintainability, and scalability.



## 5. Exception Handling
Custom exceptions like EntityNotFoundException are used to handle error scenarios gracefully instead of crashing the application.



## 6. Why Enums are Used
Enums (EnrollmentStatus) are used to represent fixed states, making the code more readable and less error-prone compared to strings.