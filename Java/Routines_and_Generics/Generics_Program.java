/* Eric Thomas
* Due Date: 07/03/2022
* Dr. Dhrgam AL Kafaf
* COP 3330C-32942 (SUMMER)
* PART 1:
* Write a routine in Java that takes an array, the length of the array, 
* and an element and returns the position of the element in the array. 
* For example, given the array with values [2, 4, 6, 8] and element 6, the routine should return 2 
* (since counting from 0, 6 occurs at position 2 in the array). Your routine should use generics to 
* enable your routine to be reusable for different element types. Be sure to test your code with a Java compiler before you submit it.
* 
* PART 2:
* Write a generic “greater-than” function that (a) takes two objects as arguments, each of which 
* has a “value” method which returns an integer; and (b) returns the argument whose “value” method returns
* the larger integer. Your generic function should constrain its type argument so that types without a “value” method cannot be  used.
*/
public class Generics_Program {

	public static void main(String []args){
		
		/*Call Position method */
		System.out.println(Element_Position.<Integer>position(new Integer[] {2, 4, 6, 8}, 6));
		
		/*Call greaterThan method */
	    System.out.println(Element_Position.<Integer>greaterThan(25, 50));
	    
	 }

}
