package dataStructures.arrays.insertionSort;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {4,2,3,1,5};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        int temp,j;
        for(int i =1;i<arr.length;i++){
            temp = arr[i];
            while(i > 0 && arr[i-1] > temp){
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = temp;
        }

        for(int i : arr){
            System.out.print(i+",");
        }
    }
}
