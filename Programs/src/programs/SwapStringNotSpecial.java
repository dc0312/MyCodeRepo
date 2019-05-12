package Programs.src.programs;

public class SwapStringNotSpecial {


    static boolean isAlphabet(char ch){
        return ((ch>='A' && ch<='Z')||(ch>='a' && ch<='z'));
    }

    public static String mainLogic(String str){
        int l=0;
        int r = str.length()-1;

        while(l<r){
            if(!isAlphabet(str.charAt(l))){
                l++;
            }else if(!isAlphabet(str.charAt(r))){
                r--;
            }else{
                str = swap(str,l,r);
                l++;
                r--;
            }
        }
        return str;
    }

    static String swap(String str, int i, int j) {
        char []c = str.toCharArray();
        char temp = c[i];
        c[i] =c[j];
        c[j]=temp;

        String newStr = new String(c);
        return newStr;
    }

    public static void main(String[] args) {
        String str = "a,bc#@";
        System.out.println(mainLogic(str));

    }
}
