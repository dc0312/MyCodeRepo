package hackerRank;

import java.util.HashMap;
import java.util.Iterator;

public class FourDigitSquares {
	public static void main(String[] argv) {
		int n = 30;
		for (String s = Integer.toString(n * n); s.length() < 5; n++, s = Integer.toString(n * n))
			if (s.length() < 4)
				continue;
			else if (s.charAt(0) == s.charAt(1) && s.charAt(2) == s.charAt(3) && s.charAt(0) != s.charAt(2))
				System.out.println(n + "^2 = " + s);
		
	}
}
