package dataStructures.arrays.freqOfCharacterWithoutLoop;

public class CharacterFreQuency {
    public static void main(String[] args) {
        String s1 = "abcbab";
        int count =  s1.length() -s1.replaceAll("a","").length();
        System.out.println(count);
    }
}
