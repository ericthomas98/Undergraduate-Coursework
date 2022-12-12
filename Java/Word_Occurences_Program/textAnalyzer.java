import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Method for counting the word frequency in a given file*/

public class textAnalyzer {

	public textAnalyzer(ArrayList<String> file) {

		//Create a HashMap to get a key/value pair
	    Map<String,Integer> wordFreqencyHashMap = new HashMap<String,Integer>();
	    
	    //Assign key/pair values 
        for (String word : file) {
            Integer itsFrequency = wordFreqencyHashMap.get(word);
            
            if (itsFrequency == null) {
            	wordFreqencyHashMap.put(word, 1);
            } else {
            	wordFreqencyHashMap.put(word, itsFrequency + 1);
            }
        }   
        new sortData(wordFreqencyHashMap);

	}
}