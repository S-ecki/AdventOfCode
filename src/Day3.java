import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Day3 {
	
	private static List<String> input = new ArrayList<String>();
	
	public Day3(String s) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(s));
		while(scanner.hasNext()) {
			input.add(scanner.next());
		}
	}
	
	public static long getSolution1() {
		return  treeNumVarSlope(3, 1);
	}
	
	public static long getSolution2() {
		return treeNumVarSlope(1, 1) * treeNumVarSlope(3, 1) * treeNumVarSlope(5, 1) * treeNumVarSlope(7, 1) * treeNumVarSlope(1, 2);
	}
	
	public static long treeNumVarSlope(int stepRight, int down) {
		long treeNum = 0;
		int posRight = 0;
		int mapWidth = input.get(0).length();
		
		for(int i = 0; i < input.size(); ) {
						
			if(input.get(i).charAt(posRight) == '#') ++treeNum;
			posRight += stepRight;
			if(posRight >= mapWidth) posRight -= mapWidth;
			
			i += down;
		}
		
		return treeNum;
	}
	
	
}
