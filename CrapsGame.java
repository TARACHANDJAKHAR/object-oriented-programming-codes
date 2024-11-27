package com.lab_7_8_9;

import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private enum Status {CONTINUE, WON, LOST}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomNumbers = new Random();
        Status gameStatus;
        int myPoint = 0;
        int sumOfDice = rollDice(randomNumbers);

        switch (sumOfDice) {
            case 7:
            case 11:
                gameStatus = Status.WON;
                break;
            case 2:
            case 3:
            case 12:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.println("Point is " + myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice(randomNumbers);

            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else if (sumOfDice == 7) {
                gameStatus = Status.LOST;
            }
        }

        if (gameStatus == Status.WON) {
            System.out.println("Player wins");
        } else {
            System.out.println("Player loses");
        }
    }

    public static int rollDice(Random randomNumbers) {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        System.out.println("Player rolled " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}

