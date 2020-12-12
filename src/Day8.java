import java.util.*;

public class Day8 extends Day {
	
	private static List<String> input = getInputLine(eight);


	public static int getSolution1() {
		int accumulator = 0;
		List<Integer> visited = new ArrayList<>();
		
		for(int i = 0; ; ++i) {
			
			if(visited.contains(i)) break;	//loop - end here and return solution
			
			visited.add(i);		//remember to find loop
			
			String op = input.get(i).substring(0, 3);	//get operation - first 3 chars
			String numArg = input.get(i).substring(4);	//get arg
			int arg = Integer.parseInt(numArg);
			
			switch(op) {	//no nop - doesnt do anything
			case("acc"): 
				accumulator += arg;
				break;
			case("jmp"): 
				i += arg-1;
				break;
			}
			
			
			
		}
		
		return accumulator;
	
	}
	
	
	public static int getSolution2() {
		
		List<Integer> nopJmpIdx = new ArrayList<>();	//get index of all nop and jmp
		for(int i = 0; i < input.size(); ++i) {		
			String op = input.get(i).substring(0, 3);
			if(op.equals("nop") || op.equals("jmp")) nopJmpIdx.add(i);
		}
		
		int accumulator = 0;
		int switchedIdx = 0;
		boolean didSwitch = false;		//nur 1 switch pro versuch
		List<Integer> visited = new ArrayList<>();
		
		for(int i = 0; ; ++i) {
			
			if(i == input.size()) break; 	//letzte op ausgefuehrt, geschafft
			
			if(visited.contains(i) || i > input.size()) {		//loop oder jmp ueber idx hinaus - reset & versuch mit and switch
				nopJmpIdx.remove(Integer.valueOf(switchedIdx));		//valueOf, um nach occurance of idx zu suchen statt idx selbst
				accumulator = 0;
				i = 0;
				visited.clear();
				didSwitch = false;
			}
			
			visited.add(i);		//idx merken um loop zu erkennen
			
			String op = input.get(i).substring(0, 3);	//get operation - first 3 chars
			String numArg = input.get(i).substring(4);
			int arg = Integer.parseInt(numArg);
			
			switch(op) {
			case("acc"): 
				accumulator += arg;
				break;
				
			case("jmp"): 
				if(nopJmpIdx.contains(i) && !didSwitch) { switchedIdx = i; didSwitch = true; }	//switch jmp - nop, remember this switch in switchedIdx
				else i += arg-1;		//normal jmp
				break;
				
			case("nop") :
				if(nopJmpIdx.contains(i) && !didSwitch) { switchedIdx = i; didSwitch = true; i += arg-1; }	//switch nop - jmp, remember this switch in switchedIdx, and do jmp
				break;
			}
		}
		
		return accumulator;
	}
}
