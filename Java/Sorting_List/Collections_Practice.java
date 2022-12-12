/*Imports*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Eric Thomas
* Due Date: 06/26/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* Write a program that will Declare an ArrayList of Strings. Add eight names to the collection. Output the Strings onto the console using the enhanced for loop.
* Sort the ArrayList using the method Collections.sort. Output the sorted List. Shuffle the list, and output the shuffled list. Note that Collections (with an s) 
* is a class, while Collection is an interface. The Collections class has many useful static methods for processing interfaces, including the sort method.
* Search for a name in the list that exists; output the location where it was found. Search for a name that is not in the list. What location is reported?
* Convert the list to an array using toArray. Output the elements of the array. Convert the array back into a list using asList. Output the elements of the list.
*/

public class Collections_Practice {
	
	public static void main(String[] args) {
		
		//Declare an ArrayList of Strings. Add eight names to the collection.
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Sebastian");
		names.add("Belisario");
		names.add("Eric");
		names.add("Maria");
		names.add("Sofia");
		names.add("Avatar");
		names.add("Isabella");
		names.add("Timmy");
		
		//Print Unsorted List
		System.out.println("********* Un-Sorted List *********");
		for(String value: names) {
			System.out.println(value);
		}
		
		//Sort names alphabetically (by default) then print to screen
		System.out.println("\n********* Sorted List *********");
		Collections.sort(names);
		for(String value: names) {
			System.out.println(value);
		}
		
		//Shuffle the list then print to screen
		System.out.println("\n********* Shuffled List *********");
		Collections.shuffle(names);
		for(String value: names) {
			System.out.println(value);
		}
		
		//Search through list for a matching name
		System.out.println("\n********* Searches Through List *********");
		if(names.contains("Isabella")){
			System.out.println("Match found for Isabella! Index location: " + names.indexOf("Isabella") + 1);
		}
		//Search through list for a name that is not there, then print message when theres no match
		if(names.contains("Bad Input")) {
			System.out.println(names.indexOf("Jackie"));
		}
		else {
			System.out.println("No Match found for Jackie! Index location: " + names.indexOf("Bad Input") + 1);
		}
		
		//Convert the list to an array then print to screen
		System.out.println("\n********* CHANGED TO AN ARRAY *********");
		String[] namesArray = names.toArray(new String[0]);
		for(int i = 0; i < namesArray.length; i++) {
			System.out.println("Name " + (i + 1) + " is " + namesArray[i]);
		}
		
		//Change back to a list then print to screen
		System.out.println("\n********* CHANGED TO A LIST *********");
	    List<String> namesArrayListReturned = Arrays.asList(namesArray);
	    for(String value: namesArrayListReturned) {
	    	System.out.println(value);
		 }
	    
	    //Exit message
	    System.out.println("\nPROGRAM WILL NOW TERMINATE");
	}
}
