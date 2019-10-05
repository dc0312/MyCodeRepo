package dataStructures.arrays.removeDuplicates;

public class RemoveDuplicates {
    public static void removeDuplicates1(int[] nums) {
        //Time Complexity : O(n) Space Complexity : O(n)
        int [] newArray = new int[nums.length];
        int j =0;
        for(int i =0; i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                newArray[j] = nums[i];
                j++;
            }
        }
        newArray[j] = nums[nums.length-1];
        for(int i=0; i<j+1;i++){
            System.out.print(newArray[i]+",");
        }
    }

    public static void removeDuplicates2(int[] nums) {
        //Time Complexity : O(n) Space Complexity : O(1)
        int [] newArray = new int[nums.length];
        int j =0;
        for(int i =0; i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length-1];
        for(int i=0; i<j+1;i++){
            System.out.print(nums[i]+",");
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,4};
        removeDuplicates1(nums);
        System.out.println();
        removeDuplicates2(nums);
    }
}
