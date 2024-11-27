package com.lab_7_8_9;

import java.util.Scanner;

public class DailyDrivingCost 
{
	
	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);

         System.out.print("Enter total miles driven per day : ");
         float miles = sc.nextFloat();

         System.out.print("Cost per gallon of gasoline : ");
         float gallon = sc.nextFloat();

         System.out.print("Average fees per day : ");
         float  fees = sc.nextFloat();

         System.out.print("Tolls per day : ");
         float Tolls = sc.nextFloat();

         float milage = 10f;

         float cost = (miles/milage)*gallon + Tolls + fees ;

         System.out.println("Your daily cost is : "+cost+" $");
         sc.close();
	}

}
