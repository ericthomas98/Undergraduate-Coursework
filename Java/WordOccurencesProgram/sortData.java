import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*This class will take in a HashMap(String, Integer) and store it in a linked list for sorting*/

public class sortData {

	public sortData(Map<String, Integer> wordFreqencyHashMap) {
		
		//Create LinkedList using the HashMap of the file
		List <Entry<String, Integer>> list = new LinkedList<Entry<String,Integer>>(wordFreqencyHashMap.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		Collections.reverse(list); //Sort in descending order
		
		//For loop to print out sorted list (Descending)
		for (Entry<String,Integer> descendingSortedList: list) {
			System.out.println(descendingSortedList);
		}
	}
}


