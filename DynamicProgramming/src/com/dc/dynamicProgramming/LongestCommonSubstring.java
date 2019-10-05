package com.dc.dynamicProgramming;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "zbcdf";
        longestCommonSubstring(s1,s2);
    }

    private static void longestCommonSubstring(String s1, String s2) {
        int T[][] = new int[s1.length()+1][s2.length()+1];
        int max = Integer.MIN_VALUE;
        int imax =0;
        int jmax=0;

        for(int i =1; i<= s1.length();i++){
            for(int j =1; j <= s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    T[i][j] = 1 + T[i-1][j-1];
                    if(max<T[i][j]){
                        max = T[i][j];
                        imax=i;
                        jmax=j;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        int i = imax;
        int j = jmax;
        while(i> 0&& j>0 && T[i][j]>0){
            sb.append(String.valueOf(s1.charAt(i-1)));
            i--;
            j--;
        }
        System.out.println(sb.reverse().toString());
        System.out.println("Max :"+max);;
    }
}
