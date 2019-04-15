package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TwoCharacters {
	
	public static final int NUM_LETTERS = 26;

    // Complete the alternate function below.
    static int alternate(String s) {
    	/* Edge case */
    	int length = s.length();	
        if (length <= 1) {
            return 0;
        }
        
        /* Create arrays representing the 26^2 subproblems */
        int [][] pair  = new int[NUM_LETTERS][NUM_LETTERS];
        int [][] count = new int[NUM_LETTERS][NUM_LETTERS];
        
        for (int i = 0; i < length; i++) {
            char letter   = s.charAt(i);
            int letterNum = letter - 'a';
            
            /* Update row */
            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }
            
            /* Update column */
            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }
        /* Find max in "count" array */
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);
        System.out.println(result);

    }
}

