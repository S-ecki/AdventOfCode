import java.io.*;
import java.util.*;

public class Day {
	
	protected final static String two = "input\\aoc2.txt";
	protected final static String three = "input\\aoc3.txt";
	protected final static String four = "input\\aoc4.txt";
	protected final static String five = "input\\aoc5.txt";
	protected final static String six = "input\\aoc6.txt";
	protected final static String eight = "input\\aoc8.txt";
	protected final static String nine = "input\\aoc9.txt";
	protected final static String ten = "input\\aoc10.txt";
	protected final static String twelve = "input\\aoc12.txt";
	protected final static String thirteen = "input\\aoc13.txt";
	protected final static String fourteen = "input\\aoc14.txt";
	protected final static String fifteen = "input\\aoc15.txt";
	protected final static String sixteen = "input\\aoc16.txt";
	protected final static String twentytwo = "input\\aoc22.txt";
	protected final static String twentyfive = "input\\aoc25.txt";
	
	protected static List<String> getInputLine(String s) {
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
	
	
	
	protected static List<String> getInputSpace(String s) {
		List<String> input = new ArrayList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(s));
			while(scanner.hasNext()) {
				input.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	protected static List<Long> getInputLong(String s){
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
	
	protected static SortedSet<Integer> getInputIntSet(String s){
		SortedSet<Integer> input = new TreeSet<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(s));
			while(scanner.hasNext()) {
				
				input.add(scanner.nextInt());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
}
