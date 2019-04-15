package hackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GradingStudent {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
    	for(int i=0;i<grades.length;i++) {
    		if(grades[i] >=38 && grades[i]%5 >= 3) {
    			grades[i] = grades[i]+(5-grades[i]%5);
    		}
    	}
    	return grades;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);
        
        for(int r:result) {
        	System.out.println(r);
        }

        
    }
}

