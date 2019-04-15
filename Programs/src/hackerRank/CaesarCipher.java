package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CaesarCipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
    	StringBuffer sb = new StringBuffer();
    	char newChar;
    	k =k %26;
    	for(char c : s.toCharArray()) {
    		if(c>='A' && c <= 'Z') {
    			newChar = (char) (c+k);
    			if(newChar>'Z') {
    				newChar = (char) ('A' + newChar -'Z' -1);
    			}
    		}else if(c>='a' && c <='z') {
    			newChar = (char) (c+k);
    			if(newChar>'z') {
    				newChar = (char) ('a' + newChar -'z' -1);
    			}
    		}else {
    			newChar = c;
    		}
    		
    		sb.append(newChar);
    	}
    	return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        System.out.println(result);
        scanner.close();
    }
}
