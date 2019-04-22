package Programs.src.hackerRank;

import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String s){

        Stack st = new Stack();

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            switch (ch){
                case '(' :
                case '{' :
                case '[' :
                    st.push(ch);
                    break;
                case ')' :
                case '}' :
                case ']' :
                    if(!st.isEmpty()){
                        char temp = (char) st.pop();
                        if( (ch==')' && temp != '(') ||
                                (ch=='}' && temp != '{') ||
                                (ch==']' && temp != '[')  ) {
                            return false;
                        }
                    }else{
                        return false;
                    }

                    break;
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "a{bc((d)e}";

        System.out.println(isBalanced(s));
    }
}
