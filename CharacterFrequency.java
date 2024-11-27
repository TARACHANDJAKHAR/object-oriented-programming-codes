package com.lab_7_8_9;

import java.util.HashMap;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the threshold: ");
        int n = scanner.nextInt();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Characters exceeding the given count:");
        for (char ch : frequencyMap.keySet()) {
            if (frequencyMap.get(ch) > n) {
                System.out.println(ch + " occurs " + frequencyMap.get(ch) + " times");
            }
        }
    }
}

