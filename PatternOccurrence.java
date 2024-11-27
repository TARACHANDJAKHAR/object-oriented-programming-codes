package com.lab_7_8_9;

import java.util.Scanner;

public class PatternOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start of the range: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end of the range: ");
        int end = scanner.nextInt();

        System.out.print("Enter the pattern to search for: ");
        String pattern = scanner.next();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (String.valueOf(i).contains(pattern)) {
                count++;
            }
        }

        System.out.println("The pattern '" + pattern + "' occurred " + count + " times in the range.");
    }
}
