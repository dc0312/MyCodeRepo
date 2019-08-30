package overLoadingOverRiddingPractice.oops6;

public class TestOops6 {
	
	public  void test(Object o) {
		System.out.println("The Object Method called.");
	}
	
	public  void test(String o) {
		System.out.println("The String Method called.");
	}
	
	
	/*public static void test(Integer o) {
		System.out.println("The Integer Method called.");
	}*/
	
	
	
	public static void main(String[] args) {
		//This method will call the most relevant method.
		//So the String method is more relevant to null 
		//But if we will uncomment Integer method as well. in that compiler will be confused which method to pick.
		//As Both are extending Object class.
	    TestOops6 oops6 = new TestOops6();
		oops6.test(null);
	}

}
