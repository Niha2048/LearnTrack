package com.airtribe.learntrack.util;

public class InputValidator {

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    
    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z]+");
    }

    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    
    public static boolean isValidBatch(String batch) {
        return isNotEmpty(batch);
    }

    
    public static boolean isValidCourseName(String name) {
        return name != null && name.matches("[A-Za-z ]+");
    }

    
    public static boolean isValidDuration(int duration) {
        return duration > 0;
    }

    
    public static boolean isValidId(int id) {
        return id > 0;
    }
}