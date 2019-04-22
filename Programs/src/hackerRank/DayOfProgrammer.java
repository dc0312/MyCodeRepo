package Programs.src.hackerRank;

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

public class DayOfProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        if(year%400 == 0 || (year%4 ==0  && year%100 != 0)  ){
            return "12.09."+year;
        }
        return "13.09."+year;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);

        bufferedReader.close();
    }
}

