package dataStructures.arrays.maxdif;

public class MaxDiff {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        maxDiff(arr);
    }

    private static void maxDiff(int[] arr) {
        int min= Integer.MAX_VALUE;
        int maxDiff = 0;
        for(int i =0; i <arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }else if(arr[i]-min>maxDiff){
                maxDiff= arr[i]-min;
            }
        }
        System.out.println(maxDiff);
    }
}
