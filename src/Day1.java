import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1{
	private static List<Integer> input = new ArrayList<Integer>();
	
	Day1() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\aoc1.txt"));
		while(scanner.hasNext()) {
			input.add(scanner.nextInt());
		}		
	}
	
	public static int getSolution() throws FileNotFoundException {
		for(int n1: input) {
			for(int n2: input) {
				for(int n3: input) {
					if(n1+n2+n3==2020) return n1*n2*n3;
				}
			}
		}
		return 0;
	}
}
