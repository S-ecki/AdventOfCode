import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Day22 extends Day {
	private static List<String> input = getInputLine(twentytwo);
	private static Queue<Integer> deck1 = new LinkedList<>();
	private static Queue<Integer> deck2 = new LinkedList<>();
	
	public Day22() {
		getDecks(input);		//initialze both decks
	}
	
	public static int getSolution1() {
		Queue<Integer> deck1Copy = new LinkedList<>(deck1);		//copy initial decks to 
		Queue<Integer> deck2Copy = new LinkedList<>(deck2);		//preserve state for Part2
		return calculateSolution(deck1Copy, deck2Copy, true);
	}
		
	public static int getSolution2() {
		return calculateSolution(deck1, deck2, false);
	}
	
	
	private static int calculateSolution(Queue<Integer> deck1, Queue<Integer> deck2, Boolean Part1) {

		int returnValue = 0;
		int winnerNumber;
		if(Part1) winnerNumber = playGame(deck1, deck2);	//play game and return which deck won
		else winnerNumber = playGameRecursive(deck1, deck2);
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
	
	
	private static int playGame(Queue<Integer> deck1, Queue<Integer> deck2) {		
		while(oneTurn(deck1, deck2));		//take turns til 1 deck is empty
		if(deck1.isEmpty()) return 2;	//return winners deck number
		if(deck2.isEmpty()) return 1;
		return 0;
	}
	
	
	private static Boolean oneTurn(Queue<Integer> deck1, Queue<Integer> deck2) {
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
	
	
	private static int playGameRecursive(Queue<Integer> deck1, Queue<Integer> deck2) {		//for part2
		HashSet<String> history = new HashSet<>();		//keep track of already-seen decks
		int winner = 0;
		
		while(!deck1.isEmpty() && !deck2.isEmpty()) {	//play til 1 deck is empty, then return winner 
			
			if(!history.add(deck1.toString())) return 1;	//if deck was already seen, player 1 wins the turn
			
			int card1 = deck1.poll();	//take next cards for turn
			int card2 = deck2.poll();
			
			if(card1 <= deck1.size() && card2 <= deck2.size()) {		//decide turn winner by subgame
				Queue<Integer> deck1Slice = new LinkedBlockingQueue<>(card1);	//create decks with first n cards
				Queue<Integer> deck2Slice = new LinkedBlockingQueue<>(card2);	//n being value of played card
				for(int card: deck1) deck1Slice.offer(card);		//fill decks for subgame
				for(int card: deck2) deck2Slice.offer(card);
				
				winner = playGameRecursive(new LinkedList<>(deck1Slice), new LinkedList<>(deck2Slice));		//only interested in which player won subgame (winner)
			}
			else { winner = card1 > card2 ? 1 : 2; }	//decide turn winner by usual comparison
			
			switch(winner) {	//winner gets both cards
			case 1:
				deck1.add(card1);
				deck1.add(card2);
				break;
			case 2:
				deck2.add(card2);
				deck2.add(card1);
			}
		}
		return winner;		//winner interesting for subgame
		
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
