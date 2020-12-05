import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
	
	public static int getSolution(String s) throws FileNotFoundException {
		
	
		Scanner input = new Scanner(new File(s));
		
		List<Integer> l = new ArrayList<>();
		
		while(input.hasNextInt()) {
			l.add(input.nextInt());
		}
		
		input.close();
		
		for(int n1: l) {
			for(int n2: l) {
				for(int n3: l) {
					if(n1+n2+n3==2020) return n1*n2*n3;
				}
			}
		}
		return 0;
	}
}
