import java.util.*;

public class Day15 extends Day {
	private static List<String> input = getInputLine(fifteen);
	
	public static int getSolution1() {
		return getSolution(2020);
	}
	
	public static int getSolution2() {
		return getSolution(30000000);
	}
	
	public static int getSolution(int maxTurns) {
		
		String[] inputSplit = input.get(0).split(",");		//convert input line to list of integers
		List<Integer> inputInt = new ArrayList<>();
		for(String s: inputSplit) {
			inputInt.add(Integer.parseInt(s));
		}
	
		
		Map<Integer, Integer> nums = new HashMap<>();	//spoken number -> timestamp of last said
		
		for(int turn = 0; turn < inputInt.size() - 1; ++turn) {		//fill map with input first
			nums.put(inputInt.get(turn), turn);
		}
		
		
		int spokenNum = inputInt.get(inputInt.size() - 1);
		int nextNum;		//last num from input
		
		for(int turn = inputInt.size() - 1; turn < maxTurns - 1; ++turn) {		//we start at 0, thus only iterate til maxTurns - 1
			
			if(nums.containsKey(spokenNum)) {		//num was already spoken
				nextNum = turn - nums.get(spokenNum);		//speak num is diff between this turn and last time it was spoken
			}
			
			else {		//num not spoken before - speak 0
				nextNum = 0;
			}
			
			nums.put(spokenNum, turn);		//put new number in map or update timestamp
			spokenNum = nextNum;		//speak next number
		}

		return spokenNum;
	}
}
