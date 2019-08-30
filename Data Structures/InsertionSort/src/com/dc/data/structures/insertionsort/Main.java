package com.dc.data.structures.insertionsort;

public class Main {

    public static void main(String[] args) {

        int [] arr = {12,3,-15,40,-22};
         for(int j =1; j<arr.length;j++){
                int newElement = arr[j];
                int i;
                for( i =j ; i>0 && arr[i-1] > newElement ; i=i-1){
                    arr[i] =arr[i-1];
                }
                arr[i] = newElement;
        }

        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}
