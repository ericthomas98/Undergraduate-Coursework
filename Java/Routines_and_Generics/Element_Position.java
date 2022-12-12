public class Element_Position {

	/*Routine in Java that takes an array, the length of the array, 
	 *and an element and returns the position of the element in the array.*/
	
    public static <Thing> int position(Thing array[], Thing element) {

        for(int i = 0; i < array.length; i++) {
        	
            if(array[i].equals(element)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /*Function that (a) takes two objects as arguments, each of which 
     *has a “value” method which returns an integer; constrain its type 
     *argument so that types without a “value” method cannot be  used.*/
    
    public static <Thing extends Number> Thing greaterThan(Thing Thing1, Thing Thing2) {
    	
        if(Thing1 == null) {
            return Thing2;
        }
        
        if(Thing1.intValue() > Thing2.intValue()) {
            return Thing1;
        } 
        
        else {
            return Thing2;
        }
    }
}