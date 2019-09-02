package code;

public abstract class GeometricObject
{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

protected GeometricObject() 
{
	dateCreated = new java.util.Date();
}

protected GeometricObject(String color, boolean filled)
{
	dateCreated = new java.util.Date();
	this.color = color;
	this.filled = filled;
}

/** Return color */
public String getColor()
{
	return color;
}

/** Set a new color */
public void setColor(String color)
{
	this.color = color;
}

/** Returned filled. Since filled is boolean,
*   the getter method is named isFilled */
public boolean isFilled()
{
	return filled;
}

/** Set a new filled */
public void setFilled(boolean filled)
{
	this.filled = filled;
}

/** Get dateCreated */
public java.util.Date getDateCreated()
{
	return dateCreated;
}

@Override
public String toString()
{
	return "Created on " + dateCreated + "\nColor: " + color + 
	"\nFilled: " + filled; 
}

/** Abstract method getArea */
public abstract double getArea();

/** Abstract method getPerimeter */
public abstract double getPerimeter();

}