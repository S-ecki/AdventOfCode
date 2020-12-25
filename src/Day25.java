import java.util.*;

public class Day25 extends Day {
	private static List<Long> input = getInputLong(twentyfive);		//publicKeys
	
	public static long getSolution1() {
		return findEncryptionKey(findLoopSize(input.get(0)), input.get(1));		//loopSize of CARD (0) with publicKey of DOOR (1)
	}
	
	public static String getSolution2() {
		return "There is nothing to see here. Everything is solved and the reindeers are waiting! Get back to the North Pole and fix the Soft Ice Machine!";
	}
	
	private static int findLoopSize(long publicKey) {	//determines loopsize for subject# 7 (door)
		int loopSize = 0;	//counter to return
		long value = 1;		//value starting at 1 - loop til this is equal to publicKey
		while(true) {
			++loopSize;
			value *= 7;			//per formula
			value %= 20201227;	//per formula
			if(value == publicKey) break;
		}
		return loopSize;
	}
	
	private static long findEncryptionKey(int loopSize, long publicKey) {	//use loopSize and publicKey of DIFFERENT subjects
		long value = 1;
		for(int i = 0; i < loopSize; ++i) {		//determines Key with subject# of publicKey and given loopSize
			value *= publicKey;
			value %= 20201227;
		}
		return value;
	}
}
