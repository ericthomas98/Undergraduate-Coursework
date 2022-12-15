/*
* Eric Thomas
* Due Date: 6/12/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* Write a program that...
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*Create scanner object*/
		Scanner Scan = new Scanner(System.in);
		
		/*Create rabbit and turtle objects*/		
		Animal rabbit = new Animal("Rabbit", 0, 150, 5);
	    Animal turtle = new Animal("Turtle", 0, 100, 3);

		/*Create thread born state with rabbit and turtle*/
	    Thread rabbitThread = new Thread(rabbit);
	    Thread turtleThread = new Thread(turtle);
	    
	    /*Set to user threads*/
	    rabbitThread.setDaemon(false);
	    turtleThread.setDaemon(false);
	    
	    /*Call start state with the respective objects to start the race for rabbit and turtle*/
		rabbitThread.start();
		turtleThread.start();
	}
}