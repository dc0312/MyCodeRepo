package programs;

import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();   
        String c1 = "t";
        String c2 = "p";
        String s1 = "Deet Chap";// Reading input from STDIN
            // Writing output to STDOUT
        int c1Pos = 0;
        int c2Pos =0;
        for(int i =0; i< s1.length();i++) {
        	if(c1.toCharArray()[0]==s1.charAt(i)) {
        		c1Pos = i;
        		break;
        	}
        }
        
        for(int i =0; i< s1.length();i++) {
        	if(c2.toCharArray()[0]==s1.charAt(i)) {
        		c2Pos = i;
        		break;
        	}
        }
        
        char [] sCharArr = s1.toCharArray();
        while(count >0) {
        char temp = sCharArr[c1Pos];
        sCharArr[c1Pos] = sCharArr[c2Pos];
        sCharArr[c2Pos] = temp;
        count--;
        }
        System.out.println(new String(sCharArr));

        // Write your code here

    }
}

