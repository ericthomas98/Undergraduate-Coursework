import javax.swing.JOptionPane;

public class Main {

	/** 
	 * @author Eric Thomas Jr.
	 * @param String[] args
	 */
	public static void main(String[] args) throws Exception{
		
		String name = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null, "Hello " + name + ", the results of your file will be displayed below!");

		new fileReader();
		new databaseMySQL();
	}
}