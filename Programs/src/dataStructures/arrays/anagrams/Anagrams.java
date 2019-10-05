package dataStructures.arrays.anagrams;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "baadb";
        System.out.println(checkAnagrams(s1,s2));
    }

    private static boolean checkAnagrams(String s1, String s2) {
        int [] counts = new int[26];

        for(char c : s1.toCharArray()){
            counts[c-'a']++;
        }

        for(char c : s2.toCharArray()){
            counts[c-'a']--;
        }

        for(int i:counts){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
