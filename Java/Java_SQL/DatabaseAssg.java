import java.sql.*;
import java.util.ArrayList;

public class DatabaseAssg {

	public static void main(String[] args) {
		//Create Person objects
		Person person1 = new Person("first1","last1", 20, 1111, 11111);
		Person person2 = new Person("first2", "last2", 25, 2222, 22222);
		Person person3 = new Person("first3", "last3", 30, 3333, 33333);


		//Call create table method
		createTable();

		//Insert the people instances
		insertPerson(person1);
		insertPerson(person2);
		insertPerson(person3);

		System.out.println(selectPerson(3));
		for(Person p: findAllPeople()){
			System.out.println(p);
		}
		//Call deletePerson Method
		deletePerson(3);
		
		//Print out findAllPeople using special for loop
		for(Person p: findAllPeople()){
			System.out.println(p);
		}
	}

	/*Write a method called findAllPeople that returns an 
	ArrayList<Person> of objects containing all the people in the database.   
	Demonstrate that it is working correctly.*/
	public static Connection deletePerson(int id) {

		Connection connection = null;
		Statement stmt = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			//SQL code to delete user
			String sql = "DELETE FROM People WHERE ID = " + id + ";";
			
			stmt.executeUpdate(sql);
			connection.commit();
			connection.close();

			//Confirmation of the ID deletion.
			System.out.println("(Person with the id: " + id + " was deleted successfully...");
			System.out.println("--------------------------------");
			//If the person is not found, have the method return that information
		} catch ( Exception e ) {
			System.out.println(e);
			connection = null;
		}
		
		return connection;
	}
	//ArrayList for Person objects
	public static ArrayList<Person> findAllPeople(){

		Connection connection = null;
		Statement statement = null;
		//Create array list and pass in a Person object as the data type
		ArrayList<Person> person = new ArrayList<>();
		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM People;");
			while ( rs.next() ) {
				person.add(new Person(
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getInt("age"), 
						rs.getInt("creditcard"),
						rs.getInt("ssn")
						));
			}
			
			rs.close();
			statement.close();
			connection.close();
			//test if method ran without errors
			System.out.println("findAllPeople executed without errors!");
			System.out.println("------------------------");
			
		} catch ( Exception e ) {
			System.out.println(e);
			person = null;
		}
		return person;
	}
	/*
	 * Write a method called selectPerson that returns a Person object. This method retrieves the data for a Person from the database. 
	 * We also need to pass a parameter to identify what person.  You can use ‘name’ 
	 * if you like, or if you find it easier to use the database generated ID that’s fine too*/
	public static Person selectPerson(int id){
		Connection connection = null;
		Statement statement = null;
		Person person = new Person();
		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM People where ID=" + id + ";");
			while ( rs.next() ) {
				person.setFirstName(rs.getString("firstname"));
				person.setLastName(rs.getString("lastname"));
				person.setAge(rs.getInt("age"));
				person.setCreditCard(rs.getInt("creditcard"));
				person.setSsn(rs.getInt("ssn"));
			}
			rs.close();
			statement.close();
			connection.close();

			//test if method ran without errors

			System.out.println("(selectPerson " + id + ") COMPLETED SUCCESSFULLY");
			System.out.println("------------------------");
			
		} catch ( Exception e ) {
			System.out.println(e);
			person = null;
		}
		return person;

	}

	/*Write a method called insertPerson(Person person) that adds a person object to your database. 
	 *Create another object of type Person, and demonstrate calling your method, passing the object to the method. */
	public static Connection insertPerson(Person person){
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			statement = connection.createStatement();
			String sql = "INSERT INTO People (FIRSTNAME,LASTNAME,AGE,SSN,CREDITCARD) " +
					"VALUES ("+
					"'" + person.getFirstName() + "'," +
					"'" + person.getLastName() + "'," +
					person.getAge() + "," +
					person.getCreditCard() + "," +
					person.getSsn() + " );";
			statement.executeUpdate(sql);

			statement.close();
			connection.commit();
			connection.close();

			System.out.println(""
					+ "(insertPerson " + 
					person.getFirstName() +
					" " + 
					person.getLastName() + ") RAN WITHOUT ERRORS...");
			
		} catch ( Exception e ) {
			System.out.println(e);
			connection = null;
		}

		return connection;
	}
	/*Create a single database table to hold information.*/
	public static Connection createTable(){
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();

			statement = connection.createStatement();
			/*SQL code for creating tables with columns
			 *1.firstName (String)
			 *2.lastName(String)
			 *3.age (int)
			 *4.ssn (long)
			 *5.creditCard (long)
			 */
			String sql = "CREATE TABLE People " +
					"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"FIRSTNAME CHAR(30) NOT NULL, " +
					"LASTNAME CHAR(30) NOT NULL, " +
					"AGE INT , " +
					"SSN BIGINT , " +
					"CREDITCARD BIGINT ) ";
			
			statement.executeUpdate(sql);
			statement.close();
			connection.close();

			System.out.println("Table created successfully");
			System.out.println("------------------------");
			
		}catch (Exception e){
			System.out.println(e);
			connection = null;
		}

		return connection;
	}
	/*Create a connection to a relational database using SQLite or MySQL.*/
	public static Connection getConnection(){
		
		Connection connection = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:MyDatabase.db");
			//print message if database opened successfully, otherwise throw exception
			System.out.println("Opened database successfully");
			System.out.println("------------------------");
			
		}catch (Exception e){
			System.out.println(e);
			connection = null;
		}

		return connection;
	}


}