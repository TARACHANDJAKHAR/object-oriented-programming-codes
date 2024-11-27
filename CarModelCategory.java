package com.lab_7_8_9;

import java.util.Scanner;

public class CarModelCategory 
{
	public static String check(String car) 
	{
		switch( car.toUpperCase() )
		{
			case "SUV" :
				return "TATA SAFARY";
			case "SEDAN" :
				return "TATA INDIGO";
			case "ECONOMY" :
				return "TATA INDICA";
			case "MINI" :
				return "TATA NANO";
			default :
				return "Invalid";
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("!.. SUV || SEDAN || ECONOMY || MINI ..!");
		System.out.print("Enter you want type : ");
		Scanner sc = new Scanner(System.in);
		String car = sc.next();
		
		System.out.println("Your Car Modal is : "+ check(car) );
	}

}
