import java.util.*;

public class Day12 extends Day{
	
	private class Instruction{		//encapsulate input lines into data type
		private char direction;
		private int value;
		private Instruction(char c, int i) {
			direction = c;
			value = i;
		}
	}
	
	private class Ship{			//keeps track of position of ship and moves it
		
		private class Waypoint{		//keeps track of the Waypoint	-	always relative to ship
			private int east = 10;	
			private int north = 1;		//given starting position for east/north
		}
		
		private int east = 0;
		private int north = 0;
		private char[] directions = new char[] {'E', 'S', 'W', 'N'};
		private int currentDirection = 0;	//index of directions array
		private Waypoint wayp = new Waypoint();		//to track waypoint of ship for solution 2
		
		private void doInstruction(Instruction instruction, Boolean s1) {	//s1 stand for Solution 1 - reusing code for solution 2 (else)
			switch(instruction.direction) {
			case 'N': if(s1) north += instruction.value; else wayp.north += instruction.value; break;	//for solution 1, directly move ship
			case 'E': if(s1) east += instruction.value; else wayp.east += instruction.value; break;		//for solutin 2, move waypoint
			case 'S': if(s1) north -= instruction.value; else wayp.north -= instruction.value; break;
			case 'W': if(s1) east -= instruction.value; else wayp.east -= instruction.value; break;
			case 'F': if(s1) moveForward(instruction.value); else moveToWaypointMultipleTimes(instruction.value); break;
			
			case 'L': if(s1) currentDirection += 4 - (instruction.value/90);			//for s1 go left in circular array - add 4 - x
					  else {
						for(int i = 0; i < instruction.value/90; ++i) {		//move waypoint counter-clockwise
							int helper = wayp.east;
							wayp.east =  wayp.north * -1;		//moving 90° left - west gets north value (west = east * -1)
							wayp.north = helper;		//north gets east value
						}
					  }
				break;
				
			case 'R': if(s1) currentDirection += (instruction.value/90); 	//for s1 go right in circular array
					  else {
						for(int i = 0; i < instruction.value/90; ++i) {		//move waypoint clockwise
							int helper = wayp.east;
							wayp.east =  wayp.north;		//moving 90° right - east gets north value
							wayp.north = helper * -1;		//south gets east value (south = north * -1)
						}
					  }	
			}
		}
		
		private void moveForward(int value) {
			doInstruction(new Instruction(directions[currentDirection%4], value), true);	//this goes back to switch with correct direction to move to
		}
		private void moveToWaypointMultipleTimes(int value) {	//moves the ship on F-instruction for solution 2
			for(int i = 0; i < value; ++i) {
				this.east += wayp.east;
				this.north += wayp.north;
			}
		}
	
	}
	
//start of Day 12 class
	
	private List<String> input = getInputLine(twelve);
	private List<Instruction> instructions = getInstructionSet(input);		//input is now list of instructions
	
	private List<Instruction> getInstructionSet(List<String> input){		//converts input strings to Instructions (own class)
		List<Instruction> instructions = new ArrayList<>();
		for(String line: input) {
			instructions.add(new Instruction(line.charAt(0), Integer.parseInt(line.substring(1))));		//first char is direction, rest is int value
		}
		return instructions;
	}
	
	
	
	public int getSolution(Boolean s1) {
		Ship ship = new Ship();
			
		for(Instruction i: instructions) ship.doInstruction(i, s1);
		
		return Math.abs(ship.east) + Math.abs(ship.north);		//return Manhattan Distance
	}
	
}
