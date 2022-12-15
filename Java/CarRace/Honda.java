/*Honda SUBCLASS*/
public class Honda extends Vehicle implements Interview{
	
	/*Honda constructor*/
	Honda(String name, int speed){
		super(name, speed);
	}

	/*Honda Interview Interface (Winner_Interview method*/
	@Override
	public String Winner_Interview() {
		String results;
		results = "*** Winner: Wow, a Honda was the right choice!! I won so easily... ***";
		return results;
	}
	
}