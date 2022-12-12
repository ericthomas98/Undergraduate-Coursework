
public class Animal_Eating implements Runnable{
	
	/*Declare local variables*/
	   protected Food food;
	   protected String name;
	   protected int position;
	   protected int speed;
	   protected int restMax;
	   protected static boolean winner = false;
	   protected int raceLength = 100;
	   
	/*Constructor*/
	public Animal_Eating(Food food) {
		this.food = food;
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
	
	public static void main(String[] args) {
		   /*Food object*/
	       Food food = new Food();
	       
		   /*Create rabbit and turtle objects*/
	       /*Rabbit*/
	       Animal_Eating rabbit = new Animal_Eating(food);
	       rabbit.setName("Rabbit");
	       rabbit.setPosition(0);
	       rabbit.setRestMax(150);
	       rabbit.setSpeed(5);	       
	       /*Turtle*/
	       Animal_Eating turtle = new Animal_Eating(food);
	       turtle.setName("Turtle");
	       turtle.setPosition(0);
	       turtle.setRestMax(100);
	       turtle.setSpeed(3);
	       
		   /*Create thread born state with rabbit and turtle*/
	       Thread rabbitThread = new Thread(rabbit);
	       Thread turtleThread = new Thread(turtle);
	       
		   /*Call start state with the respective objects to start the race for rabbit and turtle*/
	       rabbitThread.start();
	       turtleThread.start();
	   }
	
	@Override
	   public void run() {
		/*Algorithm for the race (PART 2 EATING)*/
	       while (position <= raceLength && !winner) {
	           position += speed;
	           System.out.println(getName()+" is eating.");
	           food.eat(getRestMax());
	           System.out.println(getName()+" is NOT eating.");
	           if (position >= raceLength) {
	               winner = true;	          
	           }
	       }

	   }
}
