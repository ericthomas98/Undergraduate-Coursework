import java.util.concurrent.ThreadLocalRandom;

public class Animal implements Runnable{
	
	/*Declare local variables*/
	   protected String name;
	   protected int position;
	   protected int speed;
	   protected int restMax;
	   protected static boolean winner = false;
	   protected int destination = 50;
	   
	/*Constructor*/
	public Animal(String n, int p, int s, int rM) {
		setName(n);
		setPosition(p);
		setRestMax(s);
		setSpeed(rM);
	}

	/*Getters & Setters*/
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getPosition() {
		return position;
	}

	protected void setPosition(int position) {
		this.position = position;
	}

	protected int getSpeed() {
		return speed;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	protected int getRestMax() {
		return restMax;
	}

	protected void setRestMax(int restMax) {
		this.restMax = restMax;
	}
	
	@Override
	public void run() {
		/*Algorithm for the race*/
		System.out.println("position"+position+" destination:" +destination+" winner"+winner);
	      while(position <= destination && !winner) {
	         position += speed;
	           ThreadLocalRandom.current().nextInt(0, getRestMax());
	           System.out.println("Race is still going: " + getName() + " Position: " + getPosition());
	           //Check to see if length is reached so we can end the race
	           if (position >= destination) {
	               winner = true;
	               System.out.println("Winner: " + getName());	           
	           }	           	           
	       }
	}


}
