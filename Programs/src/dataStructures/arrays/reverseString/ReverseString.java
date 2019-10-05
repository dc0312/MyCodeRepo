package dataStructures.arrays.reverseString;

public class ReverseString {
    public static void main(String[] args) {
        String s1 = "Deepak";
        System.out.println(reverse(s1.toCharArray()));
    }

    private static String reverse(char[] s1) {
        int low =0;
        int high = s1.length-1;
        while(low<high){
            char temp = s1[low];
            s1[low] = s1[high];
            s1[high] = temp;
            low++;
            high--;
        }
        return new String(s1);
    }
}
