package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindingDigit {

    // Complete the findDigits function below.
    static int findDigits(int n) {
    	
    	String [] strArr = Integer.valueOf(n).toString().split("");
    	int count=0;
    	for(String s : strArr) {
    		if(Integer.valueOf(s)!=0 && n%Integer.valueOf(s)==0) {
    			count++;
    		}
    	}
    	return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);
            	System.out.println(result);
            
        }

        

        scanner.close();
    }
}

