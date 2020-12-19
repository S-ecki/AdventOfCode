import java.io.*;
import java.util.*;

public class Day16 extends Day{
	
	private class Field {		//represents rule one on the ticket
		private Integer[] lower = new Integer[2];	//first set of rules
		private Integer[] upper = new Integer[2];	//second set of rules
		private Field(int lower0, int lower1, int upper0, int upper1) {
			lower[0] = lower0; lower[1] = lower1;
			upper[0] = upper0; upper[1] = upper1;
		}	
	}
	
	
	private class Ticket {		//ticket with its 20 vals
		private List<Integer> values = new ArrayList<>();
		private Ticket(String valString) {		//get vals from comma-seperated line
			String[] valArray = valString.split(",");
			for(String n: valArray) values.add(Integer.parseInt(n));
		}
		
		private int checkTicket(List<Field> rules) {
			for(int value: values) {
				Boolean validValue = false;
				for(Field rule: rules) {		//check value against all rules
					if(value > rule.lower[0] && value < rule.lower[1] || value > rule.upper[0] && value < rule.upper[1]) validValue = true;
				}
				if(!validValue) return value;	//if value is not valid for any rule, return it
			}
			return 0;	//all values valid and thus ticket valid
		}
	}
	

//Day 16 class begins here
	private static List<String> input = getInputLine(sixteen);	//whole input file by lines
	private static List<Field> rules = new ArrayList<>();		//list of all ticket rules
	private static Ticket myTicket;								//own ticket
	private static List<Ticket> nearbyTickets = new ArrayList<>();		//list of nearby tickets
	
	public Day16() {
		Boolean rule = true;		//logical switches for parsing
		Boolean mine = false;
		Boolean nearby = false;
		
		for(String line: input) {	
			
			if(line.isEmpty()) continue;		//skip empty lines
			if(line.equals("your ticket:")) {rule = false; mine = true; continue; }		//start parsing my ticket
			if(line.equals("nearby tickets:")) { mine = false; nearby = true; continue; }		//start parsing nearbies
			
			if(rule) {		//fill rules with all given Fields
				int lower1 = Integer.parseInt(line.split(" or ")[0].split("-")[0].split(": ")[1]);
				int lower2 = Integer.parseInt(line.split(" or ")[0].split("-")[1]);
				int upper1 = Integer.parseInt(line.split(" or ")[1].split("-")[0]);
				int upper2 = Integer.parseInt(line.split(" or ")[1].split("-")[1]);
				rules.add(new Field(lower1, lower2, upper1, upper2));
			}
			else if(mine) {		//get values of my ticket
				myTicket = new Ticket(line);
			}
			else if(nearby) {	//get list of all nearby tickets
				nearbyTickets.add(new Ticket(line));
			}
		}
	}
	
	
	public static int getSolution1() {
		int invalidSum = 0;
		
		for(Ticket t: nearbyTickets) {		//sum up all invalid values
			invalidSum += t.checkTicket(rules);
		}
		
		return invalidSum;
	}
	
}
