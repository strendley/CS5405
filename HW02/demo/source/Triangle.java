package code;

import java.lang.Math;
//import GeometicObject.java;

public class Triangle extends GeometricObject
{
	private double sideA;
	private double sideB;
	private double sideC;

	//default constructor
	public Triangle()
	{

	}

	//parameterzied constructor given 3 sides
	public Triangle(double sideA, double sideB, double sideC)
	{
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	//parameterized constructor given all aspects of the shape
	public Triangle(double sideA, double sideB, double sideC, 
		String color, boolean filled)
	{
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		setColor(color);
		setFilled(filled);
	}

	//getters & setters
	public double getSideA()
	{
		return sideA;
	}

	public void setSideA(double sideA)
	{
		this.sideA = sideA;
	}

	public double getSideB()
	{
		return sideB;
	}
		public void setSideB(double sideB)
	{
		this.sideB = sideB;
	}

	public double getSideC()
	{
		return sideC;
	}

	public void setSideC(double sideC)
	{
		this.sideC = sideC;
	}

	//return the perimeter
	public double getPerimeter()
	{
		return sideA + sideB + sideC;
	}

	//return the area
	public double getArea()
	{
		double s = getPerimeter() / 2;

		return (Math.sqrt( (s * ( (s - sideA) * (s - sideB) * 
			(s - sideC) ) ) ) );
	}


	//overload the toString method to add additional features
	public String toString()
	{
		return (super.toString() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter());
	}



} //end triangle class