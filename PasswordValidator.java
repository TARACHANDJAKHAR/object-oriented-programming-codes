package com.lab_7_8_9;

import java.util.Scanner;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasLower = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isUpperCase(ch) || !Character.isLetterOrDigit(ch)) {
                return false;
            }
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }
        return hasDigit && hasLower;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}

