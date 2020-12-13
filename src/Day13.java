import java.util.*;

public class Day13 extends Day {
	private static List<String> input = getInputLine(thirteen);
	
	public static int getSolution1() {
		
		List<Integer> busses = new ArrayList<>();
		String[] bussesOrX = input.get(1).split(",");	//seperates all busses
		for(String bus: bussesOrX) {
			if(!bus.equals("x")) busses.add(Integer.parseInt(bus));		//gets all buses that have a timestamp
		}
		
		int myTime = Integer.parseInt(input.get(0));	//my timestamp of arrival
		
		int soonestID = busses.get(0); 		//initialise with first bus
		int soonestTime = (myTime/soonestID + 1) * soonestID;	//calculate absolute time of arrival of bus (after my timestamp)
		
		for(int bus: busses) {
			int thisTime = (myTime/bus + 1) * bus;
			if(thisTime < soonestTime)	{ soonestID = bus; soonestTime = thisTime; }		//search for minimal arrival time
		}
		
		
		return (soonestTime % myTime) * soonestID;		//return as per definition
	}
}
