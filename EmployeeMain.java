package com.lab_7_8_9;

import java.util.Scanner;


class Employee
{
    private String name;
    private String l_name;
    private double salary;

    public Employee()
    {
        this.name = "Tarachand";
        this.l_name = "Jakhar";
        this.salary = 5000;
    }
    public Employee(String name,String l_name,double salary)
    {
        this.name = name;
        this.l_name = l_name;
        this.salary =salary;
    }
    public void setData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of Employee : ");
        name = sc.next();
        System.out.println("Enter the Last name of Employee : ");
        l_name = sc.next();
        System.out.println("Enter monthly salary of Employee : ");
        salary = sc.nextDouble();
    }
    public void getData()
    {
        System.out.println("Name of Employee is : "+name);
        System.out.println("Last name of Employee is : "+l_name);
        System.out.println("Yearly salary of Employee is : "+salary*12);
        System.out.println(" ");
    }

    public void hike()
    {
        double sal = salary + (salary/10);
        System.out.println("After hike details : ");
        System.out.println("Name of Employee is : "+name);
        System.out.println("Last name of Employee is : "+l_name);
        System.out.println("Now Yearly salary of Employee is : "+sal*12);
        System.out.println(" ");
    }
    
}

public class EmployeeMain 
{
	public static void main(String[] args) 
    {
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setData();
        e2.setData();

        e1.getData();
        e2.getData();
        
        e1.hike();
        e2.hike();

    } 
}
