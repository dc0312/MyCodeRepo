

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NonRepeatingDigit {

    static LinkedHashSet<Integer> getDigits(int number) {
        LinkedHashSet<Integer> digits = new LinkedHashSet<>();

        while (number != 0) {
            int nextDigit = number % 10;
            digits.add(nextDigit);
            number = number / 10;
        }

        return digits;
    }

    static int calculate(int x, int y, int z) {


        Integer number = y;

        int count = 0;
        
        while (number <= z) {

            Integer product = x * number;
            boolean isUnique = true;
            
            for(char c : number.toString().toCharArray()) {
            	if(product.toString().indexOf(c)!=-1) {
            		isUnique = false;
            	}
            }
            if(isUnique) {
            	count++;
            }
            number++;
        }


        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int x = 2, y = 10, z = 15;

        // Calling the calculate
        System.out.println(calculate(x, y, z));
    }
}
