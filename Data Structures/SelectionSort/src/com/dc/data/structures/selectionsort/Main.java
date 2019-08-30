package com.dc.data.structures.selectionsort;

public class Main {

    public static void main(String[] args) {
        int [] arr = {12, 5,18,20,1};
        for(int j = arr.length-1;j>1;j--){
            int largest = 0;
            for(int i=1;i<j;i++){
                if(arr[i] > arr[largest]){
                    largest = i;
                }
            }
            swap(arr,j,largest);
        }

        for(int i =0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
