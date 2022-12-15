import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class databaseMySQL {

		databaseMySQL() throws Exception{
			createTable();
			System.out.println("\n");
			post();
		}
		
	public static void post() throws Exception {
		final String word1 = "the";
		final String word2 = "test";
		final String word3 = "this";
		final String word4 = "a";


		try {
            Connection con = getConnection();
            
            //This is only to reset the auto increment for testing purposes
            PreparedStatement autoIncrementReset = con.prepareStatement("ALTER TABLE word AUTO_INCREMENT = 1");
            autoIncrementReset.executeUpdate();

            PreparedStatement posted1 = con.prepareStatement
                    ("INSERT INTO word (words) VALUES ('" + word1 + "') ");
            PreparedStatement posted2 = con.prepareStatement
                    ("INSERT INTO word (words) VALUES ('" + word2 + "') ");
            PreparedStatement posted3 = con.prepareStatement
                    ("INSERT INTO word (words) VALUES ('" + word3 + "') ");
            PreparedStatement posted4 = con.prepareStatement
                    ("INSERT INTO word (words) VALUES ('" + word4 + "') ");
            
            
            posted1.executeUpdate();
            posted2.executeUpdate();
            posted3.executeUpdate();
            posted4.executeUpdate();
            
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insert Completed Successfully");
		}
	}
	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS word(id int NOT NULL AUTO_INCREMENT, "
							+ "words varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table has been created");
		};
	}
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/word_counter_database";
			String username = "samohtsu";
			String password = "testDBPassword123!$";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to DB successfully..");
			return conn;

		} catch(Exception e) 
		{
			System.out.println(e);
		}

		return null;
	}
}
