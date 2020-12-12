import java.util.*;

public class Day2 extends Day{
	private static List<String> input = getInputSpace(two);
	
	public static int getSolution1() {
		int valid = 0;
		int min; int max; int currentN = 0;
		String currentS;
		String[] parts;
		char c;
		
		for(Iterator<String> it = input.iterator(); it.hasNext(); ) {
			parts = ((String) it.next()).split("-");
			min = Integer.parseInt(parts[0]);
			max = Integer.parseInt(parts[1]);
			c = ((String) it.next()).charAt(0);
			currentS = (String) it.next();
			for(int i = 0; i < currentS.length(); ++i) {
				if(currentS.charAt(i) == c) ++currentN;
			}
			if(min <= currentN && currentN <= max) ++valid;
			currentN = 0;
		}
		return valid;
	}
	
	public static int getSolution2() {
		int valid = 0;
		int first; int second; 
		String currentS;
		String[] parts;
		char c;
		
		for(Iterator<String> it = input.iterator(); it.hasNext(); ) {
			parts = ((String) it.next()).split("-");
			first = Integer.parseInt(parts[0]);
			second = Integer.parseInt(parts[1]);
			c = ((String) it.next()).charAt(0);
			currentS = (String) it.next();

			if(currentS.charAt(first-1) == c ^ currentS.charAt(second-1) == c) ++valid;
		}
		return valid;
	}
}
