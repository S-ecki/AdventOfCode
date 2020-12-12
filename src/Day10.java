import java.util.*;

public class Day10 extends Day{

	private static SortedSet<Integer> input = getInputIntSet(ten);
	
	public static int getSolution1() {
		input.add(input.last() + 3);	//add device (always 3 jolts higher than highest
		
		int OneJolt = 0; int threeJolt = 0; 
		int lastJolts  = 0;		//outlet always starts at 0 jolts
		
		for(Iterator<Integer> it = input.iterator(); it.hasNext(); ) {
			int currentJolts = it.next();
			int diffJolts =  currentJolts - lastJolts;	
			
			if(diffJolts == 3) ++threeJolt;
			else if(diffJolts == 1) ++OneJolt;
			else System.out.println("Difference =/= 1 or 3");
			lastJolts = currentJolts;
		}
		
		return OneJolt * threeJolt;
	}
	
	public static long getSolution2() {
		input.add(input.last() + 3);	//add device (always 3 jolts higher than highest
		
		int[] combinations = {0, 1, 1, 2, 4, 7};	//if there are n consecutive - number of combinations possible is at index n (never 0)
													//max cons calculated beforehand, possible combinations by hand
		int lastJolts  = 0;
		int consecCount = 1;	//always "one consecutive" - number itself
		long solution = 1;		//always multipl. combinations
		
		 
		
		for(Iterator<Integer> it = input.iterator(); it.hasNext(); ) {
			int currentJolts = it.next();
			
			if(currentJolts - lastJolts == 1) ++consecCount;	//count how many consecutive jolts are in a "group" (group: seperated by 3 jolt diff)
			else {
				solution *= combinations[consecCount];		//new group - multiply possible comb
				consecCount = 1;
			}
			
			lastJolts = currentJolts;
		}
		
		return solution;
	}
	
	
	public static int maxCons() {	//count the max number of consecutive jolts
		
		int lastJolts  = 0;
		int consecCount = 1;
		int maxConsec = 1;
		
		for(Iterator<Integer> it = input.iterator(); it.hasNext(); ) {
			int currentJolts = it.next();
			
			if(currentJolts - lastJolts == 1) ++consecCount;
			else {
				if(consecCount > maxConsec) maxConsec = consecCount;
				consecCount = 1;
			}
			lastJolts = currentJolts;
		}
		
		return maxConsec;
	}
}
