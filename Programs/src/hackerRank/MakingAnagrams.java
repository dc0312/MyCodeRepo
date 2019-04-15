package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
    	
    	int [] arr1 = new int[26];
    	int [] arr2 = new int[26];
    	
    	for(char c : s1.toLowerCase().toCharArray()) {
    		arr1[c-'a']++;
    	}
    	for(char c: s2.toLowerCase().toCharArray()) {
    		arr2[c-'a']++;
    	}
    	
    	int count =0;
    	
    	for(int i=0; i< arr1.length;i++) {
    		count+=Math.abs(arr1[i]-arr2[i]);
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        System.out.println(result);
        scanner.close();
    }
}
