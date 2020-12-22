import java.util.*;

public class Day22 extends Day {
	private static List<String> input = getInputLine(twentytwo);
	private static Queue<Integer> deck1 = new LinkedList<>();
	private static Queue<Integer> deck2 = new LinkedList<>();
	
	public Day22() {
		getDecks(input);		//initialze both decks
	}
	
	public static int getSolution1() {
		return calculateSolution();
	}
		
	
	
	private static int calculateSolution() {

		int returnValue = 0;
		int winnerNumber = playGame();	//play game and return which deck won
		int multiplicator;		//needed for returned calculation
		
		switch(winnerNumber) {
		case 1: 	//deck1 won
			multiplicator = deck1.size();
			for(int i: deck1)	returnValue += i * multiplicator--;		//calculation per definition
			break;
		case 2:		//deck2 won
			multiplicator = deck2.size();
			for(int i: deck2)	returnValue += i * multiplicator--;			
		}
		
		return returnValue;
	}
	
	
	private static int playGame() {		
		while(oneTurn());		//take turns til 1 deck is empty
		if(deck1.isEmpty()) return 2;	//return winners deck number
		if(deck2.isEmpty()) return 1;
		return 0;
	}
	
	
	private static Boolean oneTurn() {
		int card1 = deck1.poll();
		int card2 = deck2.poll();
		
		if(card1 > card2) {		//deck1 wins a turn
			deck1.add(card1);	//add both cards to deck1
			deck1.add(card2);
		}
		else {		//deck 2 wins a turn
			deck2.add(card2);
			deck2.add(card1);
		}
		
		return !deck1.isEmpty() && !deck2.isEmpty();	//returns false as soon as 1 deck is empty
	}
	
	
	private static void getDecks(List<String> input){	//method to convert input to decks
		Boolean Player1 = true;
		for(String line: input) {
			if(line.contains("Player")) continue;	//skip line with chars
			if(line.isEmpty()) { Player1 = false; continue; }	//Player2 starts after empty line
			if(Player1) deck1.add(Integer.parseInt(line));		//add to respective deck
			else deck2.add(Integer.parseInt(line));
		}
	}
}
