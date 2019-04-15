package hackerRank;

import java.io.IOException;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {
    	int count=1;
    	for(char c : s.toCharArray()) {
    		if(c>='A' && c<='Z') {
    			count++;
    		}
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        int result = camelcase(s);
        System.out.println(result);

        scanner.close();
    }
}
