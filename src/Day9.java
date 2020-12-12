import java.util.*;

//this was a day I had particularily little time to work with, excuse the spaghetti future-simon
public class Day9 extends Day{
	private static List<Long> input = getInputLong(nine);
	
	public static long getSolution1() {
		
		for(int i = 25; i < input.size(); ) {		//validate numbers - first 25 preamble
			long searchFor = input.get(i);
			middle:
			for(int ii = i - 25; ii < i; ++ii) {	
				if(ii == i-1) return searchFor;
				long validator1 = input.get(ii);
				for(int iii = ii + 1; iii < i; ++iii) {
					long validator2 = input.get(iii);
					if(validator1 + validator2 == searchFor) {
						++i;
						break middle;
					}
				}
			}
		}
		return 0;
	}
	
	
	public static long getSolution2() {
		long invalidNum = getSolution1();
		int start = 0;
		int end = 0;
		outer:
		for(int i = 2; i < input.size(); ++i) {		//length of numbers to sum up
			for(int ii = 0; ii < input.size() - i+1; ++ii) {	//+1?
				if(sumOfN(ii, i) == invalidNum) { start = ii; end = ii + i-1; break outer;}
			}		
		}
		long min = findMinMax(start, end, true);
		long max = findMinMax(start, end, false);
		return min+max;
	}
	
	
	static long sumOfN(int start, int n) {
		long sum=0;
		for(int i=0; i<n; i++) {        
			sum += input.get(start+i);     
		}
	    return sum;
	}
	
	static long findMinMax(int start, int end, boolean min) {
		long ret = input.get(start);
		for(int i = start; i < end; ++i) {
			if(min) if(input.get(i) < ret) ret = input.get(i);
			else if(input.get(i) > ret) ret = input.get(i);
		}
		return ret;
	}
}
