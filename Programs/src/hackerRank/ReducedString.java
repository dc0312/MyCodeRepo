package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
    	
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(char c : s.toCharArray()) {
    		if(!stack.isEmpty() && c == stack.peek()) {
    			stack.pop();
    		}else {
    			stack.push(c);
    		}
    	}
    	
    	if(stack.isEmpty()) {
    		return "Empty String";
    	}else {
    		StringBuffer sb = new StringBuffer();
    		for(char c : stack) {
    			sb.append(c);
    		}
    		return sb.toString();
    	}
    	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);
        System.out.println(result);
    }
}

