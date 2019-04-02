package programs;

import java.util.HashMap;
import java.util.Map;

public class MaxRepeatedWord {
	
	public static void main(String[] args) {
		String s = "Deepal is is is Deepak Deepak is a a a a a a";
		
		String [] sArr = s.split(" ");
		
		Map<String,Integer> sMap = new HashMap<>();
		
		for(String s1 : sArr) {
			if(sMap.containsKey(s1)) {
				sMap.put(s1, sMap.get(s1)+1);
			}else {
				sMap.put(s1, 1);
			}
		}
		int temp =0;
		String tempKey = new String();
		for(String key : sMap.keySet()) {
			if(sMap.get(key) >temp) {
				temp = sMap.get(key);
				tempKey=key;
			}
		}
		
		System.out.println(tempKey);
	}

}
