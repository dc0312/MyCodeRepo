package com.dc.dynamicProgramming;

public class KnapSack {

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        int val[] = {2,3,4,1};
        int wt[] = {3,4,5,6};
        int r = knapSack.bottomUpDP(val, wt, 8);
        System.out.println(r);
    }

    private int bottomUpDP(int[] val, int[] wt, int W) {
        int K [][] = new int[val.length+1][W+1];

        for(int i =0; i<= val.length;i++){
            for(int j =0; j<=W;j++){
                if(i ==0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j < wt[i-1]){
                    K[i][j] = K[i-1][j];
                }else{
                    K[i][j] = Math.max(K[i-1][j], val[i-1]+ K[i-1][j-wt[i-1]]);
                }
            }
        }
        return K[val.length][W];
    }
}
