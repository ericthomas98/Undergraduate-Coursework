/*
* Eric Thomas
* Due Date: 06/19/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* Write a program that will simulate a race between several vehicles. The Vehicles will implement 
* an inheritance hierarchy that includes Vehicle as an abstract superclass and several subclasses.
* Will include at least one interface with at least one method that implementing classes will have.
* Write the results of the race to a file utilizing exception handling and utilize threads for the
* vehicles to ensure they are moving in turn.
*/

/* Vehicle Types: Bugatti/ Audi/ Honda */

public class Car_Race_Program {

	public static void main(String[] args) {
		/*Global Variables*/
		int raceLength = 50;
		
		/*Create contestants array that will create a Vehicle and that vehicles speed*/
        RaceContestant[] contestants = 
        {
            new RaceContestant(new Bugatti("Bugatti", 1)),
            new RaceContestant(new Audi("Audi", 5)),
            new RaceContestant(new Honda("Honda", 10)),
        };
        
		/*Create raceManager object that takes in contestants array, length of the race,
		 * the minimum speed, and maximum speed of the cars.*/
        RaceManager raceManager = new RaceManager(contestants, raceLength, 2, 10);
        
        /*Thread start*/
        new Thread(raceManager).start();
	}
}