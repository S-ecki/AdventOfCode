import java.io.*;
import java.util.*;

public class Day {
	
	protected static List<String> getInput(String s) {
		List<String> input = new ArrayList<String>();
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
}
