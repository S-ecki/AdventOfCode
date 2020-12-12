import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6 extends Day{

		private static List<String> input = getInputLine(six);
		
		
		public static long getSolution1() {
			
			long result = 0;
			List<String> newInput = new ArrayList<String>();	//concate strings, seperate by blank line
			StringBuffer group = new StringBuffer();
			
			for(String line: input) {
				if(line.isEmpty()) { newInput.add(group.toString()); group.delete(0, group.length()); }		//empty line - new group
				else group.append(line);	//else same group
			}
			newInput.add(group.toString());		//last element of list - no new line afterwards
		
			for(String line: newInput) {
				result += line.chars().distinct().count();	//stream of chars from each group - sum up distinct chars for all groups
			}
			
			return result;
		}
		
		
		public static long getSolution2() {
			
			long result = 0;
			HashMap<Character, Integer> nChars = new HashMap<>();	//map distinct chars to number of appearance in group
			int groupSize = 0;
			
			for(String line: input)
				
				if(line.isEmpty()) {	//empty line - new group
					for(int value: nChars.values()) {	//iterate over values of map (created in else)
						if(value == groupSize) ++result;	//number of appearance of char (value) must be equal to groupSize - then it counts towards result
					}
					groupSize = 0;	//new group after blank line - reset size and map
					nChars.clear();
				}
					
				else {		//same group, new person
					++groupSize;
					for(int i = 0; i < line.length(); ++i) {	//iterate over chars in line
						nChars.merge(line.charAt(i), 1, (a,b) -> a+b);		//fill up map: char is key, value is number of appearances (1 if null before, else add 1
					}
				}
			
			for(int value: nChars.values()) {		//like in solution 1, last element must be handled seperately - no new line afterwards
				if(value == groupSize) ++result;
			}
			
			return result;
		}
		
}
