package com.airtribe.learntrack.util;

public class InputValidator {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}