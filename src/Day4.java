import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day4 {

	private static List<String> input = new ArrayList<String>();
	
	public Day4(String s) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(s));
		while(scanner.hasNext()) {
			input.add(scanner.nextLine());
		}
	}
	
	public static int getSolution1() {
		int valid = 0;
		boolean ecl = false, byr = false, iyr = false, pid = false, hgt = false, eyr = false, hcl = false;
		
		for(Iterator<String> it = input.iterator(); it.hasNext(); ) {
			String line = it.next();
			
			if(line.equals("")) {
				if(ecl && byr && iyr && pid && hgt && eyr && hcl) ++valid;
				ecl = false; byr = false; iyr = false; pid = false; hgt = false; eyr = false; hcl = false; 
			}
			else {
				if(line.contains("ecl")) ecl = true;
				if(line.contains("byr")) byr = true;
				if(line.contains("iyr")) iyr = true;
				if(line.contains("pid")) pid = true;
				if(line.contains("hgt")) hgt = true;
				if(line.contains("eyr")) eyr = true;
				if(line.contains("hcl")) hcl = true;
			}
		}
		
		return valid;
		
	}
	
	
	
	
	public static int getSolution2() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		int valid = 0;
		boolean ecl = false, byr = false, iyr = false, pid = false, hgt = false, eyr = false, hcl = false;
		
		for(String line: input) {
			if(line.equals("")) {
				
				if(map.containsKey("ecl")) {
					String key = map.get("ecl");
					if(key.equals("amb") || key.equals("blu") || key.equals("brn") || key.equals("gry") || key.equals("grn") || key.equals("hzl") || key.equals("oth")) ecl = true;	      
				}

				if(map.containsKey("byr")) {
					int key = Integer.parseInt(map.get("byr"));
					if(key >= 1920 && key <= 2002) byr = true;
				}
				
				if(map.containsKey("iyr")) {
					int key = Integer.parseInt(map.get("iyr"));
					if(key >= 2010 && key <= 2020) iyr = true;
				}
				
				if(map.containsKey("pid")) {
					String key = map.get("pid");
					if(key.length() == 9) pid = true;
				}
				
				if(map.containsKey("hgt")) {
					String key = map.get("hgt");
					
					if(key.contains("in")) {
						int keyNum = Integer.parseInt(key, 0, key.length()-2, 10);
						if(keyNum >= 59 && keyNum <= 76) hgt = true;
					}
					if(key.contains("cm")) {
						int keyNum = Integer.parseInt(key, 0, key.length()-2, 10);
						if(keyNum >= 150 && keyNum <= 193) hgt = true;
					}
				}
				
				if(map.containsKey("eyr")) {
					int key = Integer.parseInt(map.get("eyr"));
					if(key >= 2020 && key <= 2030) eyr = true;
				}
				
				if(map.containsKey("hcl")) {
					boolean sureFalse = false;
					String key = map.get("hcl");
					if(key.charAt(0) == '#' && key.length() == 7) {
						for(int i = 1; i < 7; ++i) {
							char c = key.charAt(i);
							if(c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c!= 'f') {sureFalse = true; break;}
						}
					}else {sureFalse = true;}
					hcl = !sureFalse;
				}
				
				if(ecl && byr && iyr && pid && hgt && eyr && hcl) ++valid;
				
				System.out.println(map);
				System.out.println((ecl && byr && iyr && pid && hgt && eyr && hcl));
				System.out.println("ecl " + ecl);
				System.out.println("byr " + byr);
				System.out.println("iyr " + iyr);
				System.out.println("pid " + pid);
				System.out.println("hgt " + hgt);
				System.out.println("eyr " + eyr);
				System.out.println("hcl " + hcl);
				ecl = false; byr = false; iyr = false; pid = false; hgt = false; eyr = false; hcl = false;
				map.clear();
			}
			
			else {
				String[] comp = line.split(" ");
				for(int i = 0; i < comp.length; ++i) {
					map.put(comp[i].split(":")[0], comp[i].split(":")[1]);
				}
			}
		}
				
				
		return valid;
	}
	
	
	
}
