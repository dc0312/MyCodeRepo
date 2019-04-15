package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    		
    	int posCounter = 0;
    	int negCounter =0;
    	int zeroCounter =0;
    	
    	int length = arr.length;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]>0) {
    			posCounter++;
    		}else if(arr[i]<0) {
    			negCounter++;
    		}else {
    			zeroCounter++;
    		}
    	}
    	
    	System.out.println((double)posCounter/length);
    	System.out.println((double)negCounter/length);
    	System.out.println((double)zeroCounter/length);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
