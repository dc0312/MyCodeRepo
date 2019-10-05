package dataStructures.arrays.mergeSort;

public class MergeSort {

    static int [] tempArr;
    static int [] arr;
    public static void main(String[] args) {
        int [] arr = {8,2,7,1,3,5,4,6};
        mergeSort(arr,0,arr.length);
        for(int i : arr){
            System.out.print(i+",");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(end - start < 2){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int [] tempArr = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j <end){
            tempArr[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i<mid){
            tempArr[k++] = arr[i++];
        }

        System.arraycopy(tempArr,0,arr,start,k);
    }

}
