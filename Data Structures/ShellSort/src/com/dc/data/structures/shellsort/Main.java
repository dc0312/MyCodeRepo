package com.dc.data.structures.shellsort;

public class Main {

    public static void main(String[] args) {

        int arr [] = {12,15,-2,10,-22};

        for(int j=1; j<arr.length;j++){
            int element = arr[j];
            int i;
            for(i =j; i>0 && arr[i-1]>element;i--){
                arr[i] = arr[i-1];
            }
            arr[i] = element;
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
