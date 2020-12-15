import java.util.*;

//no time for Part 2 
//perhaps come back to it later

public class Day14 extends Day {
	private static List<String> input = getInputLine(fourteen);
	
	
	public static long getSolution1() {
		
		Map<Long, Long> memory = new HashMap<>();	//key - mem address
		String mask = "";	
		
		for(String line: input) {
			if(line.contains("mask")) mask = line.split(" ")[2];	//extract mask from line
			else {	
				long saveTo = Integer.parseInt(line.substring(line.indexOf("[")+1, line.indexOf("]")));		//extract mem address between [] and parse to Int
				long valueNoMask = Integer.parseInt(line.split(" ")[2]);		//extract value and parse to Int
				long valueWithMask = applyMask(mask, valueNoMask);			//value after bitmask
				memory.put(saveTo, valueWithMask);		//save value to mem address
			}
		}
		
		return memory.values().stream().reduce(0l, (a,b) -> a+b);	//sum up all saved values and return
	}
	
	public static long applyMask(String mask, long value) {
		String binaryShort = Long.toBinaryString(value);					//get binary of number
		char[] bin = new char[36];		//create char Array for easier application of mask
		int missingZeros = 36 - binaryShort.length();		//missing 0 to prepend for 36 bit binary
		
		for(int i = 0; i < missingZeros; ++i) {		//prepend 0s
			bin[i] = '0';
		}
		for(int i = missingZeros; i < 36; ++i) {	//write actual number after leading 0s
			bin[i] = binaryShort.charAt(i - missingZeros);
		}
		
		for(int i = 0; i < mask.length(); ++i) {	//iterate over chars in mask
			if(mask.charAt(i) != 'X')	bin[i] = mask.charAt(i); 	//override with mask - X is wildcard in mask
		}
		
		return Long.parseLong(new String(bin), 2);	//create String from char Array and parse it to long (overload radix 2)
	}
	
}
