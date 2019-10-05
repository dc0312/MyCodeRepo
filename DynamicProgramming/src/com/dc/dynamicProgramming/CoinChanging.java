package com.dc.dynamicProgramming;
/*Given a total and coins of certain denominations find number of ways total
        can be formed from coins assuming infinity supply of coins*/
public class CoinChanging {

    public static void main(String[] args) {
        CoinChanging cc = new CoinChanging();
        int total = 8;
        int coins[] = {1,3,5};
        System.out.println(cc.numberOfSolutions(total,coins));
        System.out.println(cc.minimumCoin(total,coins));
        System.out.println(cc.minimumCoin2(total,coins));
    }

    private int numberOfSolutions(int total, int[] coins) {
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }

    private int minimumCoin(int total, int[]coins){
        int temp [] [] = new int[coins.length+1][total+1];

        for(int i =0; i<=coins.length;i++){
            temp[i][0] = 0;
        }

        for(int j =1; j <= total; j++){
            if(j>=coins[0] && j%coins[0]==0){
                temp[0][j] = j/coins[0];
            }
        }

        for(int i =1; i<=coins.length;i++){
            for(int j=1; j<= total;j++){
                if(coins[i-1]>j){
                    temp[i][j] = temp[i-1][j];
                }else{
                    temp[i][j] = Math.min(temp[i-1][j], 1+temp[i][j-coins[i-1]]);
                }
            }
        }
        return temp[coins.length][total];
    }

    public int minimumCoin2(int total, int [] coins){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int i=0; i < coins.length; i++){
            for(int j=1; j <= total; j++){
                if(j >= coins[i]){
                    if (T[j - coins[i]] + 1 < T[j]) {
                        T[j] = 1 + T[j - coins[i]];
                        R[j] = i;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
    }

    private void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }
}
