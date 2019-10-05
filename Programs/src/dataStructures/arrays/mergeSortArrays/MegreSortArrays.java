package dataStructures.arrays.mergeSortArrays;

public class MegreSortArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3};
        int [] arr2 = {1,2,3};
        merge(arr1,arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k =0;
        int [] arr3 = new int[arr1.length+arr2.length];
        while(i<arr1.length && j <arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr1[j++];
            }
        }
        while(i<arr1.length){
            arr3[k++] = arr1[i++];
        }
        while(j<arr2.length){
            arr3[k++]= arr2[j++];
        }
        for(int a : arr3){
            System.out.print(a+",");
        }
    }
}
