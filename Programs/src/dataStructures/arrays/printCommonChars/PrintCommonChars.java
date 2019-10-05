package dataStructures.arrays.printCommonChars;

import java.util.ArrayList;
import java.util.List;

public class PrintCommonChars {
    public static void main(String[] args) {
        String [] words = {"abcc","bcc","cc"};
        System.out.println(commonsChars(words));
    }

    private static List<String> commonsChars(String[] words) {

        int [] counts = new int[26];

        for(char c : words[0].toCharArray()){
            counts[c-'a']++;
        }

        for(int i =1; i<words.length;i++){
            counts = getCommonCharCount(words[i],counts);
        }
        List<String> list = new ArrayList<>();
        for(int i =0; i<counts.length;i++){
            while(counts[i]>0){
                list.add(""+(char)(i+97));
                counts[i]--;
            }
        }
        return list;
    }

    private static int[] getCommonCharCount(String word, int[] counts) {
        int [] commonCharCount = new int[26];
        for(char c : word.toCharArray()){
            if(counts[c-'a']>0){
                counts[c-'a']--;
                commonCharCount[c-'a']++;
            }
        }
        return commonCharCount;
    }
}
