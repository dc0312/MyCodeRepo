package hackerRank;

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

public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
    	
    	int count=0;
    	int temp=m;
    	
    	for(int i=0;i<=s.size()-m;i++) {
    		int sum=0;
    		m=temp;
    		while(m>0 && i<=s.size()-m) {
    			sum=sum+s.get(i+m-1);
    			m--;
    		}
    		if(sum==d) {
    			count++;
    		}
    	}
    	return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(result);
    }
}

