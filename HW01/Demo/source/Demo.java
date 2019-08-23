package code;
//@Author: Skylar Trendley
//Assignment: Homework 1
//Description: Calculates the area of a regular sided polygon given the
//length of the sides and the number of sides.
import java.util.Scanner;
import java.lang.Math;

public class Demo
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("=====================================");
		System.out.println("Homework 1 Demo");
		System.out.println("Created By: Skylar Trendley");
		System.out.println("=====================================");
		System.out.println("");
		
		System.out.print("Enter the number of sides: ");
		int sides = scanner.nextInt();
		
		System.out.print("Enter the length of the sides: ");
		int length = scanner.nextInt();

		Calculator calc = new Calculator();
		double shapeArea = calc.Area(sides,length);

		System.out.print("The area of your polygon is: ");
		System.out.println(shapeArea);

	}
}

class Calculator
{
	public static double Area(int numberOfSides, int lengthOfSide)
	{
		double result = (numberOfSides * Math.pow(lengthOfSide,2)) / (4 * Math.tan(Math.PI/numberOfSides));
		return result;	
	}
}
