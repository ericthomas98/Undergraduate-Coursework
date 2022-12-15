//CIRCLE CLASS 
public class Circle {
	//LOCAL VARIABLES
	double radius = 0;
	
	//0 arg-Circle Constructor
	public Circle() {
		radius = 0;
	}
	
	//CIRCLE CONSTRUCTOR
	public Circle(double r) {
		radius = r;
	}
	
	//GETTERS
	public double getRadius() {
		return radius;
	}

	//SETTERS
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//COMPUTE CIRCLE'S AREA
	double computeArea() {
		double area;
		double pi = Math.PI;
		area = pi * radius * radius;
		return area;
	}
	
	//PRINT STATEMENTS FOR CIRCLE 1
	public String toString() {
		String circ1Area;
		circ1Area = "Circle with radius " + radius + " has area " + computeArea();
		return circ1Area;
	}
	//PRINT STATEMENTS FOR CIRCLE 2
	public String toString2() {
		String circ2Area;
		circ2Area = "Circle with radius " + radius + " has area " + computeArea();
		return circ2Area;
	}
}
