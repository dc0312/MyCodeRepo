package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
    	
    			String numbers = "0123456789";
    			String lower_case = "abcdefghijklmnopqrstuvwxyz";
    			String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    			String special_characters = "!@#$%^&*()-+";
    			
    			boolean numFlag = false;
    			boolean numLow = false;
    			boolean numUp = false;
    			boolean special = false;
    			
    			for(char c : password.toCharArray()) {
    				if(numbers.contains(c+"")) {
    					numFlag=true;
    				}else if(lower_case.contains(c+"")) {
    					numLow=true;
    				}else if(upper_case.contains(c+"")) {
    					numUp=true;
    				}else if(special_characters.contains(c+"")){
    					special=true;
    				}
    			}
    			
    			int count = 0;
    			
    			if(!numFlag) {
    				count++;
    			}
    			
    			if(!numLow) {
    				count++;
    			}
    			
    			if(!numUp) {
    				count++;
    			}
    			
    			if(!special) {
    				count++;
    			}
    			
    			if(count+n<6) {
    				count = 6-n;
    			}
    			
    			return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);
        scanner.close();
    }
}

