package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WeigthedUniform {

    // Complete the weightedUniformStrings function below.
    static void weightedUniformStrings(String s, int[] queries) {
    	String [] str = new String[queries.length];
    	HashMap<Character,Integer> map1 = new HashMap<>();
    	
    	HashMap<Character, Integer> map2 = new HashMap<>();
    	
    	for(char c : s.toCharArray()) {
    		map1.merge(c, 1, Integer::sum);
    	}
    	
    	for(char c : s.toCharArray()) {
    		if(!map2.containsKey(c)) {
    			map2.put(c, map1.get(c)*(c-96));
    		}
    	}
    	
    	for(int q : queries) {
    		if(map2.containsValue(q)) {
    			System.out.println("YES");
    		}else {
    			System.out.println("NO");
    		}
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

         weightedUniformStrings(s, queries);

        /*for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
            	System.out.println("\n");
            }
        }*/


        scanner.close();
    }
}
