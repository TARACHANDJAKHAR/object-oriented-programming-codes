package com.lab_7_8_9;

import java.util.Scanner;

class Date
{
    private int month;
    private int day;
    private int year;

    public Date()
    {
        this.month = 1;
        this.day = 1;
        this.year = 2001;
    }
    public Date(int month,int day,int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public void setData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month of date : ");
        month = sc.nextInt();
        System.out.println("Enter the day of date : ");
        day = sc.nextInt();
        System.out.println("Enter the year of date : ");
        year = sc.nextInt();
    }
    public void getData()
    {
        String m;
        switch (month) {
            case 1:
                m = "Jan.";
                break;
            case 2:
                m = "Fab.";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break;
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "July";
                break;
            case 8:
                m = "Aug.";
                break;
            case 9:
                m = "Sep.";
                break;
            case 10:
                m = "Oct.";
                break;
            case 11:
                m = "Nov.";
                break;
            case 12:
                m = "Dec.";
                break;
            default:
                m = "month";
        }
        System.out.println("The DATE is : "+m+" "+day+","+year+".");
        System.out.println(" ");
    }

}

public class DateFormate 
{
	public static void main(String[] args) 
    {
        Date d = new Date();
        d.setData();
        d.getData();
    } 
}
