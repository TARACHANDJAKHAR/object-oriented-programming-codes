package com.lab_7_8_9;

import java.util.Scanner;

class  Invoice
{
    private String number;
    private String description;
    private int quantity;
    private double price;

    public Invoice()
    {
        this.number = " ";
        this.description = "  ";
        this.quantity = 0;
        this.price = 0;
    }
    public Invoice(String number,String description,int quantity,double price)
    {
        this.number = number;
        this.description = description;
        if(quantity <= 0)
        {
            this.quantity = 0;
        }
        else
        {
            this.quantity = quantity;
        }
        if(price <= 0)
        {
            this.price = price;
        }
        else
        {
            this.price = price;
        }
    }
    public void display()
    {
        System.out.println("The part number is "+number);
        System.out.println("The part description is "+description);
    }
    public double getAmount()
    {
        return price*quantity;
    }

}


public class InvoiceMain 
{

	public static void main(String[] args) 
	{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the part number : ");
        String number = sc.nextLine();

        System.out.println("Enter the discription : ");
        String description = sc.nextLine();

        System.out.println("Enter the quantity of items");
        int quantity = sc.nextInt();

        System.out.println("Enter the price of items");
        double price = sc.nextDouble();

        Invoice A = new Invoice(number,description,quantity,price);

        A.display();
        System.out.println("Total amount is : "+A.getAmount());

	}

}
