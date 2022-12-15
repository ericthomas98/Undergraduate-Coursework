
/*Bugatti subclass*/
public class Bugatti extends Vehicle implements Interview {
	
	/*Bugatti constructor*/
	Bugatti(String name, int speed){
		super(name, speed);
	}

	/*Bugatti Interview Interface (Winner_Interview method*/
	@Override
	public String Winner_Interview() {
		String results;
		results = "*** Winner: Wow, a Bugatti was the right choice!! I won so easily... ***";
		return results;
	}
}