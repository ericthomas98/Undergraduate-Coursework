/*
* Eric Thomas
* 5/16/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* Write a program that has a rectangle and circle Constructor that utilizes getters and setters. The program will calculate the
* area of the rectangles and circles and then neatly print it out on the screen.
*/

//SHAPES CLASS
public class Main {

	public static void main(String[] args) {
		
			//RECTANGLE SECTION
			Rectangle rect1 = new Rectangle(4,5); //Create Rectangle 1 using Constructor
			Rectangle rect2 = new Rectangle(5.7,8.1); //Create Rectangle 2 using Constructor
			
			//CIRCLE SECTION
			Circle circ1 = new Circle(3.2); //Create Circle 1 using Circle Constructor
			Circle circ2 = new Circle(4);   //Create Circle 2 using Circle Constructor
			
			//Print length, width, and area of Rectangles 1 and 2
			System.out.println(rect1);
			System.out.println(rect2);
			
			//Print radius and area of Circles 1 and 2
			System.out.println(circ1);
			System.out.println(circ2);
	}
}
