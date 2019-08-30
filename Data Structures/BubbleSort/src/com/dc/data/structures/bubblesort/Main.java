package com.dc.data.structures.bubblesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = {12,10,-3,20,-2};

        for(int i = arr.length-1;i>=0;i--){
            for(int j =0 ; j<i;j++){
                if(arr[j] > arr[i]){
                    swap(arr, j , i);
                }
            }
        }

        for(int i =0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
