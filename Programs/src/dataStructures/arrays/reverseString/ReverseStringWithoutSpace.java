package dataStructures.arrays.reverseString;

public class ReverseStringWithoutSpace {
    public static void main(String[] args) {
        String s = "abc d";
        reverse(s);
    }

    private static void reverse(String s) {
        int low =0;
        int high = s.length()-1;
        char [] chars = s.toCharArray();
        while(low<high){
            if(chars[low]==' ' ){
                low++;
            }
            if(chars[high] == ' '){
                high--;
            }

            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
        System.out.println(new String(chars));
    }
}
