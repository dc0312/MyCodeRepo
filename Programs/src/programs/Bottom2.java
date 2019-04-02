package programs;
class Top{
	public Top(String s ) {
		System.out.print("B");
	}
}
public class Bottom2 extends Top {

	public Bottom2(String s) {
		super(s);
		System.out.print("D");
	}
	
	public static String test() {
		try {
			System.out.println("deepak");
			return "deepak";
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("deepak final");
		}
		return "aditya";
	}
	
	public static void main(String[] args) {
		new Bottom2("C");
		System.out.println();
		test();
		
		String s1 = "AAB";
		String s2 = "BAA";
		
		char [] c1 = s1.toCharArray();
		int sum1 =0;
		for (char c : c1) {
			sum1 += c;
		}
		System.out.println(sum1);
		char [] c2 = s2.toCharArray();
		int sum2 =0;
		for (char c : c2) {
			sum2 += c;
		}
		System.out.println(sum2);
		if(c1.length==c2.length && sum1 == sum2) {
			System.out.println("Anagram");
		}
		
	}
	
}

