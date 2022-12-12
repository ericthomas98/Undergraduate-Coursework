public class Person {
	
	//Person Attributes: firstName (String), lastName(String), age (int), ssn (long),creditCard (long)
	protected String firstName;
	protected String lastName;
	protected int age;
	protected long ssn;
	protected long creditCard;

	//Zero-arg constructor
	Person(){
		
	}
	
	//Full(5)-arg constructor
	Person(String firstName, String lastName, int age, long creditCard, long ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ssn = ssn;
		this.creditCard = creditCard;
	}

	/*Getters and Setters*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public long getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Person)) return false;
		Person person = (Person) obj;
		return getSsn() == person.getSsn();
	}

	//Print out results
	@Override
	public String toString() {
		return  "------------------------" +
				"\nPerson:" +
				"\n First Name: " + firstName +
				"\n Last Name: " + lastName +
				"\n Age: " + age +
				"\n Last four of social: " + ssn +
				"\n Last five of credit card: " + creditCard;
	}
	
}