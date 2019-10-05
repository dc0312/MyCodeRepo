package dataStructures.arrays.intersectionOfTwoArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class INtersectionOfTwoArray {

    public static void main(String[] args) {
        int [] nums1 = {9,};
        int [] nums2 = {1,1};
        intersection(nums1,nums2);
        System.out.println();
        intersection1(nums1,nums2);
    }

    private static void intersection1(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i =0;i<nums1.length;i++){
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }

        for(int i =0; i < nums2.length;i++){
            if(hm.containsKey(nums2[i]) && null!=hm.get(nums2[i]) && hm.get(nums2[i]) >0){
                al.add(nums2[i]);
                hm.put(nums2[i],hm.get(nums2[i])-1);
            }
        }

        int [] res = new int[al.size()];
        for(int i =0 ; i < res.length;i++){
            res[i] = al.get(i);
        }
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        int [] counts = new int[256];
        List<Integer> list = new ArrayList<>();

        for(int i : nums1){
            counts[i]++;
        }
        for(int i : nums2){
            if(counts[i]>0){
                System.out.print(i+",");
                list.add(i);
            }
            counts[i]--;
        }
        int [] result = new int[list.size()];
        for(int i =0; i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
