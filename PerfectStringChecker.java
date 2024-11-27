package com.lab_7_8_9;

import java.util.HashSet;
import java.util.Scanner;

public class PerfectStringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        HashSet<Character> charSet = new HashSet<>();
        boolean isPerfect = true;

        for (char ch : input.toCharArray()) {
            if (!charSet.add(ch)) {
                isPerfect = false;
                break;
            }
        }

        if (isPerfect) {
            System.out.println("The string is perfect.");
        } else {
            System.out.println("The string is not perfect.");
        }
    }
}
