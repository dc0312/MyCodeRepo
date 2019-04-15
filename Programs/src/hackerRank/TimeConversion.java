package hackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
    	
    	if(s.substring(0,2).equals("12")&&s.substring(s.length()-2, s.length()).equals("AM")) {
    		return "00"+s.substring(2,s.length()-2);
    	}else if(s.substring(0,2).equals("12")&&s.substring(s.length()-2, s.length()).equals("PM")) {
    		return "12"+s.substring(2,s.length()-2);
    	}
    	switch (s.substring(s.length()-2, s.length())) {
		case "AM":
			s= s.substring(0, s.length()-2);
			break;
		case "PM":
			s = 12+Integer.parseInt(s.substring(0,2)) + s.substring(2,s.length()-2);
			break;
		default:
			break;
		}
    	
    	return s;
         

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scan.nextLine();

        String result = timeConversion(s);
        
        System.out.println(result);

    }
}

