package dataStructures.arrays.bubbleSort;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {1,5,3,4,2};
        bubbleSort(arr);
        System.out.println();
        bubbleSort1(arr);
    }

    private static void bubbleSort(int[] arr) {
        for(int i = arr.length-1;i>1;i--){
            for(int j =0;j<i;j++){
                if(arr[j]>arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i : arr){
            System.out.print(i+",");
        }
    }

    //More Efficient
    private static void bubbleSort1(int[] arr) {
        for(int i = arr.length-1;i>1;i--){
            boolean flag = false;
            for(int j =0;j<i;j++){
                if(arr[j]>arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }

        for(int i : arr){
            System.out.print(i+",");
        }
    }
}
