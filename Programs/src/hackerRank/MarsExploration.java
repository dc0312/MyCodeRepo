package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
    	
    	StringBuffer sb = new StringBuffer();
    	
    	int repCount = s.length()/3;
    	
    	while(repCount>0) {
    		sb.append("SOS");
    		repCount--;
    	}
    	int diffCount =0;
    	for(int i =0; i<s.length();i++) {
    		if(s.charAt(i)!=sb.charAt(i)) {
    			diffCount++;
    		}
    	}
    	return diffCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        int result = marsExploration(s);

        System.out.println(result);
        scanner.close();
    }
}
