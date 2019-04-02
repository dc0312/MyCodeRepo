package programs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DupChars {
	public static void test(String o) {
		System.out.println("String called");
	}
	public static void test(Object o) {
		System.out.println("bject called");
	}
	
	public static void main(String[] args) {
		String s = "Deepaaaak";
		
		Map<Character,Integer> dupMap = new HashMap<>();
		
		char [] c = s.toCharArray();
		
		for(char c1 :c) {
			if(dupMap.containsKey(c1)) {
				dupMap.put(c1, dupMap.get(c1)+1);
			}else {
				dupMap.put(c1, 1);
			}
		}
		
		for(char val : dupMap.keySet()) {
			if(dupMap.get(val)>1) {
				System.out.println(val);
			}
		}
		
		test(null);
	}

}
