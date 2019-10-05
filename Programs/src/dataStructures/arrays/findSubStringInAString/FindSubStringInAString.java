package dataStructures.arrays.findSubStringInAString;

public class FindSubStringInAString {
    public static void main(String[] args) {
        String s1 = "Deepak";
        String s2 = "pak";
        findSubString(s1,s2);
    }

    private static void findSubString(String s1, String s2) {
        boolean flag = false;
        if(s1.length()<s2.length()){
            System.out.println(flag);
        }

        for(int i =0; i<=s1.length()-s2.length();i++){
            if(s1.substring(i,i+s2.length()).equals(s2)){
                flag = true;
            }
            if(flag){
                break;
            }
        }
        if(flag){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
