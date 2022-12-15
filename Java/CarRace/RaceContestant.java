public class RaceContestant {

    private Vehicle vehicle;
    private int position = 0;
    
    public RaceContestant(Vehicle vehicle) {
    	this.vehicle = vehicle;
    }
    
    public Vehicle getVehicle() {
    	return vehicle;
    }
    
    public int getPosition() {
    	return position;
    }

    public void setPosition(int position) {
    	this.position = position;
    }

    public void incrementPosition(int by) {
    	position += by;
    }
}