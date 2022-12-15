abstract class Vehicle implements Interview{
	/*Variables for Vehicle superclass*/
    private String name;
    private int speed;
    /*Vehicle constructor that takes a name and speed.
     * I could have made many more variables such as color and 
     * sponsor, etc.. but did not for simplicities sake*/
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    /*Getters & Setters*/
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    /*Vehicle superclass toString method*/
    public String toString() {
    	String results;
    	/*Call the Winner_Interview method from the Interview interface*/
    	results = Winner_Interview();
		return results;
    }
    
}