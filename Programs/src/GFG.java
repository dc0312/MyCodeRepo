
// Java program to print minimum number that can be formed  
// from a given sequence of Is and Ds  
import java.io.*; 
import java.util.*; 
public class GFG { 
  
	static int PrintMinNumberForPattern(String seq) { 
        StringBuilder result = new StringBuilder(); 
  
        Stack<Integer> stack = new Stack<Integer>(); 
        
        HashSet<Character> set = new HashSet<>();
        set.add('M');
        set.add('N');
        
        for(int i =0;i<seq.length();i++) {
        	if(!set.contains(seq.charAt(i))) {
        		return -1;
        	}
        }
        
        if(null==seq || seq.length()==0) {
        	return -1;
        }
  
        for (int i = 0; i <= seq.length(); i++) { 
        	
        	
        	stack.push(i + 1); 
  
             
            if (i == seq.length() || seq.charAt(i) == 'N') { 
                while (!stack.empty()) { 
                    result.append(stack.pop());
                } 
            } 
        } 
  
        return Integer.parseInt(result.toString()); 
    } 
  
// main function 
    public static void main(String[] args) { 
        System.out.println(PrintMinNumberForPattern("MX")); 
    } 
}