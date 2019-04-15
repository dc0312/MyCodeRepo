package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DiagonalDifference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
    	
    	int leftDiagonalSum = 0;
    	int rightDiagonalSum =0;
    	
    	for(int i=0;i<arr.length;i++) {
    		leftDiagonalSum = leftDiagonalSum + arr[i][i];
    	}
    	
    	for(int i =0; i<arr.length;i++) {
    		rightDiagonalSum = rightDiagonalSum + arr[i][Math.abs(i-arr.length)-1];
    	}
    	
    	return Math.abs(leftDiagonalSum-rightDiagonalSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        System.out.println(result);
        scanner.close();
    }
}
