package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count=0;
    	HashMap<String, Integer> map = new HashMap<>();
    	for(int  i =0; i<s.length();i++) {
    		for(int j=i+1;j<=s.length();j++) {
    			String currentString = s.substring(i, j);
    			char [] c = currentString.toCharArray();
    			Arrays.sort(c);
    			currentString = new String(c);
    			
    			if(map.containsKey(currentString)) {
    				count+=map.get(currentString);
    				map.put(currentString, map.get(currentString)+1);
    				
    			}else {
    				map.put(currentString, 1);
    			}
    		}
    	}
    	return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }


        scanner.close();
    }
}

