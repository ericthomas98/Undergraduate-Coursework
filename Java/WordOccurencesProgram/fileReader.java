import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*Method for reading in given a file and storing it in an ArrayList*/
public class fileReader {

	public fileReader() {
	}
	
	public int inputFile(int wordCounter) {
	//Declare Array list to hold the files
			ArrayList<String> file = new ArrayList<String>();

			try {
				Scanner scan = new Scanner(new File("TheRaven.txt")); //Give the file location

				while(scan.hasNextLine()) {
					String data = scan.next();
					if(data.matches("[a-zA-Z']+")) {
						file.add(data);
					}
					wordCounter++;

				}
				
				new textAnalyzer(file); //Call textAnalyzer method and pass in the file object

				scan.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return wordCounter; 
			
	}

}	