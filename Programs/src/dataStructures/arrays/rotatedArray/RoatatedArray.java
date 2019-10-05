package dataStructures.arrays.rotatedArray;

public class RoatatedArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        countRotation(arr);
    }

    private static void countRotation(int[] arr) {
        for(int i =0; i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                System.out.println(i+1);
                break;
            }
        }
        System.out.println("0");
    }
}
