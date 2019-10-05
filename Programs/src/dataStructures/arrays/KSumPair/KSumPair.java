package dataStructures.arrays.KSumPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KSumPair {
    public static void main(String[] args) {
        //int [] arr = {1,2,2,1,1};
        int k =12;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(13);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(6);
        arrayList.add(3);
        arrayList.add(3);
        System.out.println(findPairSum(arrayList,k));
    }

    private static int findPairSum(ArrayList<Integer> arr, long k) {
//        HashMap<Integer,Integer> hm = new HashMap();
//        for(int i =0;i<list.size();i++){
//            if(hm.containsKey(list.get(i))){
//                System.out.println(list.get(i)+","+hm.get(list.get(i)));
//            }else{
//                int num = (int) list.get(i);
//                hm.put(k-num,num);
//            }
//        }
//        return hm.size();
        Map<Integer, Integer> frequencies = new HashMap<>();
        int pairsCount = 0;

        for(int i=0; i<arr.size(); i++){
            int value = arr.get(i);
            int complement = (int) (k - arr.get(i));

            if(frequencies.containsKey(complement)){
                int freq = frequencies.get(complement) - 1;
                pairsCount++;
                //System.out.println(value + ", " + complement);
                if(freq == 0){
                    frequencies.remove(complement);
                }else{
                    frequencies.put(complement, freq);
                }
            }else{
                if(frequencies.containsKey(value)){
                    frequencies.put(value, frequencies.get(value) + 1);
                }else{
                    frequencies.put(value, 1);
                }
            }
        }
        return pairsCount;
    }
}
