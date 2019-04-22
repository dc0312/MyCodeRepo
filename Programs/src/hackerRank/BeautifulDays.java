package Programs.src.hackerRank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class BeautifulDays {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count =0;
        while(i<=j){
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            sb.reverse();
            int irev = Integer.parseInt(sb.toString());
            if( (i-irev) % k ==0){
                count++;
            }
            i++;
        }
        return  count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(result);
        scanner.close();
    }
}

