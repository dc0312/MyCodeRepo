package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class JavaAnagram {

    static boolean isAnagram(String a, String b) {
        // Complete the function
    	
    	if(a.length()!=b.length()) {
    		return false;
    	}
    	
    	int [] arr1 = new int[26];
    	
    	for(char c : a.toLowerCase().toCharArray()) {
    		arr1[c-'a']++;
    	}
    	
    	for(char c : b.toLowerCase().toCharArray()) {
    		arr1[c-'a']--;
    	}
    	
    	for(int i : arr1) {
    		if(i>0) {
    			return false;
    		}
    	}
    	return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
