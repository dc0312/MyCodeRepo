package dataStructures.arrays.KdiffPair;

import java.util.HashMap;
import java.util.Map;

public class KDiffPair {
    public static void main(String[] args) {
        int [] arr = {3,1,4,1,5};
        int k = 2;
        findPairs(arr,k);
    }
    public static int findPairs(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i =0; i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int count =0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (hm.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
