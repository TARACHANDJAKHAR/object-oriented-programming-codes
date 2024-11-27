package com.lab_7_8_9;

import java.util.Scanner;

class Trip
{
	int miles;
	int gallon;
	static int totalMiles = 0;
	static int totalGallon = 0;

	float avg;
	float avg1;
	Trip()
	{
		miles = 1;
		gallon = 1;
		totalMiles = totalMiles + miles ;
		totalGallon = totalGallon + gallon;
	}
	Trip(int miles,int gallon)
	{
		this.miles = miles;
		this.gallon = gallon;
		totalMiles = totalMiles + miles;
		totalGallon = totalGallon + gallon;
	}
	public void avg() 
	{
		avg = (float)miles / gallon;
		System.out.println("Miles of this trip is : "+miles);
		System.out.println("Gallon of this trip is : "+gallon);
		System.out.println("Average of this trip is : "+avg);
		System.out.println(" ");
	}
	public void totalAvg() 
	{
		avg1 = (float)totalMiles / totalGallon;
		System.out.println("Total miles of all trip is : "+totalMiles);
		System.out.println("Total gallon of all trip is : "+totalGallon);
		System.out.println("Total average of all trip is : "+avg1);
		System.out.println(" ");
	}
}

public class GasMileage 
{

	public static void main(String[] args) 
	{
		int miles = 0;
		int gallon = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter miles and gallon 00 for the tramination .");
		
		do
		{
			System.out.print("Enter miles for the trip : ");
			miles = sc.nextInt();
			System.out.print("Enter gallon for the trip : ");
			gallon = sc.nextInt();
			System.out.println(" ");
			
			if ( miles == 0 || gallon == 0) 
			{
				continue;
			}
			else
			{
				Trip t = new Trip(miles,gallon);
				t.avg();
			}
		}
		while ( miles != 0 || gallon != 0 );
		
		Trip t1 = new Trip(0,1);
		t1.totalAvg();
		sc.close();
	}

}
