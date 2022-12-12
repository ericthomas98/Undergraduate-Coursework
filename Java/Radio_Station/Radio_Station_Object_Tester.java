/*
* Eric Thomas
* 5/31/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* Write a program that creates an array of six RadioStation objects with user generated input for call signs and carrier frequencies.
*
*/
import java.util.Scanner;

public class Radio_Station_Object_Tester {

	public static void main(String[] args) {
		
		//Create Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Declare Variables
		String radioSignature; 
		double radioFrequency;
		
		//Create array of objects to hold scanned in values
		RadioStation[] radioStationObjectsArray = new RadioStation[2];
		
		//Try statement to ensure to scanner closes	
	        for(int i = 0; i < radioStationObjectsArray.length; i++){
	        	 
		        	//Prompt and scan in user value for the call sign
	        		if(i != 0) {
	        			System.out.println("\n");
	        		}
	        		
		        	System.out.println("Enter callsign #" + (i + 1) + "...");
		        	radioSignature = scan.nextLine();
		        	
		        	//Prompt and scan in user value for the frequency
		        	System.out.println("Enter frequency #" + (i + 1) + "...");
		        	radioFrequency = scan.nextDouble();
		        	scan.nextLine(); //Clear buffer

		        	//Try creating the object with the users input
		        	try {
		        		RadioStation testObject = new RadioStation(radioSignature, radioFrequency);
		        		System.out.println("Object successfully recorded...");
		        	}
		        	//Catch the exception when creating the object
		        	catch(RadioStationException e) {
		        		System.out.println(e.getMessage());
		        	}
	        }
	        
	        System.out.println("\nApplication will now terminate...");
	}
			
}
		