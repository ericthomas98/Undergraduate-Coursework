/*Audi subclass */
public class Audi extends Vehicle implements Interview{
	
	public Audi(String name, int speed) {
		super(name, speed);
	}

	/*Audi Interview Interface (Winner_Interview method*/
	@Override
	public String Winner_Interview() {
		String results;
		results = "*** Winner: Wow, an Audi was the right choice!! I won so easily... ***";
		return results;
	}
}