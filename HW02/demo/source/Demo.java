package code;
//@Author: Skylar Trendley
//Assignment: Homework 2
/** Description: Extends the GeometricObject class to create a 
 *  triangle displaying the area, perimeter, color, and filled values. */

import java.util.Scanner;
//import Triangle.java;

public class Demo
{
	public static void main(String[] args)
	{
		//create a new scanner to grab input
		Scanner scanner = new Scanner(System.in);

		System.out.println("=====================================");
		System.out.println("Homework 2 Demo");
		System.out.println("Created By: Skylar Trendley");
		System.out.println("=====================================");
		System.out.println("");
		
		//take in all input for the triangle
		System.out.print("Enter the length of Side A: ");
		double A = scanner.nextDouble();

		System.out.print("Enter the length of Side B: ");
		double B = scanner.nextDouble();

		System.out.print("Enter the length of Side C: ");
		double C = scanner.nextDouble();

		System.out.print("Enter a color: ");
		String color = scanner.next();

		System.out.print("Is the triangle filled? Enter Y for yes, N for no: ");
		char filled = scanner.next().charAt(0);

		System.out.println("");
		System.out.println("Your Triangle is.....");

		boolean isFilled = false;

		//determine the boolean value of filled
		if(filled == 'Y' || filled == 'y')
		{
			isFilled = true;
		}

		//create a new triangle object using the parameterized constructor
		Triangle triangle = new Triangle(A,B,C,color,isFilled); 

		//print out the characteristics of the triangle
		System.out.println(triangle.toString());
	}
}