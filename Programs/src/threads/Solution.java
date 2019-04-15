package threads;

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

public class Solution {
	public static void main(String[] args) {


	    Scanner scanner = new Scanner(System.in);

	    int A = scanner.nextInt();

	    int P = scanner.nextInt();

	    int a = scanner.nextInt();
	    double semiPerimeter = P / 2;

	    int sumOfOtherSides = Math.abs(P - a);

	    int bSecondSide = sumOfOtherSides - 1;
	    int cThirdSide = 1;

	    int count = 0;
	    while (bSecondSide >= sumOfOtherSides / 2) {

	        double aa = 2 * (semiPerimeter * ((semiPerimeter - a) * (semiPerimeter - bSecondSide) * (semiPerimeter - cThirdSide)));

	        double newArea = Math.sqrt(aa);
	        if (newArea > A) {
	            count++;
	        }
	        bSecondSide--;
	        cThirdSide++;
	    }

	    System.out.println(count);
	}
}
