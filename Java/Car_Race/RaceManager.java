/*Imports*/
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom; // Import the theadLocalRandom for the race
import java.io.FileWriter;
import java.io.IOException;

/*RaceManager class*/
public class RaceManager implements Runnable {
	/*Local variables*/
    private RaceContestant[] contestants;
    private int raceLength;
    private int minSpeed = 0;
    private int maxSpeed = 10;
    
    /*Create scanner object*/
	Scanner scan = new Scanner(System.in);
    /*Race manager constructor*/
    public RaceManager(RaceContestant[] contestants, int raceLength, int minSpeed, int maxSpeed) {
        this.contestants = contestants;
        this.raceLength = raceLength;
        /* Random number between 1-10 for the racers position. Doesn't allow numbers smaller than 1 for rand speed*/ 
        this.minSpeed = Math.max(1, minSpeed); 
        this.maxSpeed = Math.max(10, maxSpeed);

    }
    
    /*Override run method for the raceManager*/
    @Override
    public void run() {
		
            System.out.println("*** Andddd the race is off!!!*** \n");
    	try {
    		/*Open file*/
    		FileWriter writer = new FileWriter("C:\\Users\\thoma\\Documents\\Race.txt");

	        /*While loop to continue until the race declares a winner*/
	    	while (true) {
	            /*Race has started message.*/
	        		/*For loop to cycle through the entirety of the race.*/
                writer.write("\n");

		            for (int i = 0; i < contestants.length; i++) {
		            	/*Algorithm for the race*/
		                RaceContestant contestant = contestants[i];
		                int tickSpeed = minSpeed == 0 ? contestant.getVehicle().getSpeed() : ThreadLocalRandom.current().nextInt(minSpeed, maxSpeed);
		                contestant.incrementPosition(tickSpeed);
		                
		                /*Each contestant will be printed out here as well as the lap they are on*/
		                System.out.println(contestants[i].getVehicle().getName() + " is on lap " + contestants[i].getPosition());
		                writer.write(contestants[i].getVehicle().getName() + " is on lap " + contestants[i].getPosition());
		                writer.write("\n");
		                
		                /*If check for the winner of the race*/
		                if (contestants[i].getPosition() >= raceLength) {              
		                    System.out.println("");
		                    /*Announce winner and write it to file*/
		                    System.out.println("*** " + contestants[i].getVehicle().getName() + " has won the race! ***");
		                    writer.write("*** " + contestants[i].getVehicle().getName() + " has won the race! ***");
		                    System.out.println("");

		                    /*Interview the winner and write it to file*/
		            		System.out.println("*** Interviewer: Here we are with the winner of the race, what are your thoughts? ***");
		            		writer.write("*** Interviewer: Here we are with the winner of the race, what are your thoughts? ***");
			                writer.write("\n");
		                    System.out.println(contestants[i].getVehicle().Winner_Interview());
		                    writer.write(contestants[i].getVehicle().Winner_Interview());;
		                    
		                    /*Message showing the thread is finished and exited*/
		    	            System.out.println("");
		                	System.out.println("Thanks for coming out, have a nice day! (Program will now terminate...)");
		                	
		                    /*Close file*/
		        	    	writer.close();
		                    return;
		                } /*Winner for loop END bracket*/
		            } /*Contestants cycle END bracket*/
		            
		        /*Pause the thread for 1 second*/
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }/*Thread pause END bracket*/
	            
	            /*White space at the end of the while loop*/
	            System.out.println("");
	        } /*Race loop END bracket*/  
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}/*Run method END bracket*/
} /*RaceManager END bracket*/