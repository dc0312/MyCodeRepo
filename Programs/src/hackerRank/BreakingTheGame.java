package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingTheGame {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
    	
    	int min=scores[0];
    	int max = scores[0];
    	int minCount =0;
    	int maxCount =0;
    	
    	for(int s : scores) {
    		if(s<min) {
    			min=s;
    			minCount++;
    		}else if(s>max){
    			max=s;
    			maxCount++;
    		}
    	}
    	
    	return new int[]{maxCount,minCount};

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for(int r:result) {
        	System.out.print(r+" ");
        }

        scanner.close();
    }
}

