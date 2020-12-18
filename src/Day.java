import java.io.*;
import java.util.*;

public class Day {
	
	protected final static String two = "AdventOfCode\\input\\aoc2.txt";
	protected final static String three = "AdventOfCode\\input\\aoc3.txt";
	protected final static String four = "AdventOfCode\\input\\aoc4.txt";
	protected final static String five = "AdventOfCode\\input\\aoc5.txt";
	protected final static String six = "AdventOfCode\\input\\aoc6.txt";
	protected final static String eight = "AdventOfCode\\input\\aoc8.txt";
	protected final static String nine = "AdventOfCode\\input\\aoc9.txt";
	protected final static String ten = "AdventOfCode\\input\\aoc10.txt";
	protected final static String twelve = "AdventOfCode\\input\\aoc12.txt";
	protected final static String thirteen = "AdventOfCode\\input\\aoc13.txt";
	protected final static String fourteen = "AdventOfCode\\input\\aoc14.txt";
	protected final static String fifteen = "AdventOfCode\\input\\aoc15.txt";
	protected final static String sixteen = "AdventOfCode\\input\\aoc16.txt";
	
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
