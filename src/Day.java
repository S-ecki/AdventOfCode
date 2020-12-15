import java.io.*;
import java.util.*;

public class Day {
	
	protected final static String two = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc2.txt";
	protected final static String three = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc3.txt";
	protected final static String four = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc4.txt";
	protected final static String five = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc5.txt";
	protected final static String six = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc6.txt";
	protected final static String eight = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc8.txt";
	protected final static String nine = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc9.txt";
	protected final static String ten = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc10.txt";
	protected final static String twelve = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc12.txt";
	protected final static String thirteen = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc13.txt";
	protected final static String fourteen = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc14.txt";
	protected final static String fifteen = "S:\\Coding\\Eclipse\\Workspace\\Uni\\AdventOfCode\\src\\input\\aoc15.txt";
	
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
