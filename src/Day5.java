import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 extends Day{

	private static List<String> input = getInputLine(five);
	
	
	public static int getSeatID(String s) {
		double upper = 127.0; double lower = 0.0;
		
//get row by binary search
		for(int i = 0; i < 7; ++i) {
			if(s.charAt(i) == 'F') upper -= Math.ceil((upper - lower)/2);
			else if(s.charAt(i) == 'B') lower += Math.ceil((upper-lower)/2);
			else throw new IllegalArgumentException("First 7 chars must be F or B");
		}
		int row = (int) upper;
		
//get seat by binary search
		lower = 0; upper = 7;
		for(int i = 7; i < 10; ++i) {
			if(s.charAt(i) == 'L') upper -= Math.ceil((upper - lower)/2);
			else if(s.charAt(i) == 'R') lower += Math.ceil((upper-lower)/2);
			else throw new IllegalArgumentException("Last 3 chars must be input or R");
		}
		int seat = (int) upper;
		
//ID per given formula
		return row * 8 + seat;
	}
	
	
	public static int getSolution1() {
//search max ID from input file
		int maxID = 0;
		for(String line: input) {
			if(getSeatID(line) > maxID) maxID = getSeatID(line);
		}
		return maxID;
	}
	
	
	public static int getSolution2() {
//get sorted List of IDs
		List<Integer> IDs = new ArrayList<Integer>();
		for(String line: input) IDs.add(getSeatID(line));
		Collections.sort(IDs);
//search for missing ID, start at index 1 (increment in for-loop before first comparison)
		int missing = IDs.get(0);
//if next ID is not next natural number - it is missing
		for(int i = 1; i < IDs.size(); ++i ) {
			if(IDs.get(i) != ++missing) return missing;
		}
		return 0;
	}
}