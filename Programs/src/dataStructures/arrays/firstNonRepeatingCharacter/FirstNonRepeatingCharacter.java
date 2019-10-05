package dataStructures.arrays.firstNonRepeatingCharacter;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "dac";
        System.out.println(findFirstNonRepeatingCharacter(s));
    }

    private static char findFirstNonRepeatingCharacter(String s) {
        int [] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c-'a']++;
        }

        for(int i =0; i<s.length();i++){
            if(counts[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return 0;
    }
}
