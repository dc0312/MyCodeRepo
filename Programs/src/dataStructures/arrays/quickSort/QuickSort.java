package dataStructures.arrays.quickSort;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {15,20,7,9,30};
        quickSort(arr,0,arr.length-1);

        for(int i : arr){
            System.out.print(i+",");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low+high)/2];
        while(low<=high){
            while (arr[low]<pivot){
                low++;
            }
            while(arr[high]>pivot){
                high--;
            }
            if(low<=high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
}
