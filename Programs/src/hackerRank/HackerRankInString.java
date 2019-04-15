package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerRankInString {

	// Complete the hackerrankInString function below.
	static String hackerrankInString(String s) {

		/*
		 * String regEx = ".*[h].*[a].*[c].*[k].*[e].*[r].*[r].*[a].*[n].*[k].*";
		 * 
		 * if(s.matches(regEx)) { return "YES"; }else { return "NO"; }
		 */
		String str = "hackerrank";
		if (s.length() < str.length()) {
			return "NO";
		}
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (j < str.length() && s.charAt(i) == str.charAt(j)) {
				j++;
			}
		}
		return (j == str.length() ? "YES" : "NO");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			String result = hackerrankInString(s);
			System.out.println(result);

		}

		scanner.close();
	}
}
