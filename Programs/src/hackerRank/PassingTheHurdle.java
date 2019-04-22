package Programs.src.hackerRank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class PassingTheHurdle {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int in,out,min;

        for(out=0;out<height.length-1;out++){
            min = out;
            for(in =out+1;in<height.length;in++){
                if(height[in] < height[min]){
                    min = in;
                }
            }

            int temp = height[min];
            height[min] = height[out];
            height[out] = temp;
        }

        if(height[height.length-1] > k){
            return height[height.length-1] -k;
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        System.out.println(result);
        scanner.close();
    }
}

