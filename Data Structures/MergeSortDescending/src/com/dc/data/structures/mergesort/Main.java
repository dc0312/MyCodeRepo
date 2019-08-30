package com.dc.data.structures.mergesort;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int arr [] = {20,-3,18,92,-32};
        mergeSort(arr,0,arr.length);
        for(int i =0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int [] arr, int start, int end){
        if(end-start<2){
            return;
        }

        int mid = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i=start;
        int j = mid;
        int [] temp = new int [end-start];
        int tempIndex = 0;

        while(i < mid && j < end ){
            temp[tempIndex++] =  arr[i] <= arr[j] ? arr[j++] : arr[i++];
        }

        while (j<end){
            temp[tempIndex++] = arr[j++];
        }

        System.arraycopy(temp,0,arr,start,tempIndex);
    }
}
