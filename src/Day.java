import java.io.*;
import java.util.*;

public class Day {
	
	protected static List<String> getInput(String s) {
		List<String> input = new ArrayList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(s));
			while(scanner.hasNext()) {
				input.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	protected static List<Long> getInputInt(String s){
		List<Long> input = new ArrayList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(s));
			while(scanner.hasNext()) {
				
				input.add(Long.parseLong(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
}
