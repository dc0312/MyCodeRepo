package Programs.src.hackerRank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int count =0;
        int valley =0;

        for(int i =0; i<s.length();i++){
            if(s.charAt(i) == 'U'){
                count++;
                if(count==0){
                    valley++;
                }
            }else{
                count--;
            }
        }
        return valley;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}

