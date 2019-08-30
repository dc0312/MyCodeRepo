package overLoadingOverRiddingPractice.oops5;

interface Test1{
	default void test() {
		System.out.println("Test1 default.");
	}
}
interface Test2{
	default void test() {
		System.out.println("Test2 default.");
	}
}

interface Test3 extends Test1,Test2{

	@Override
	default void test() {
		Test1.super.test();
		System.out.println("Test3 default");
	}
	
}
public class TestOops5 implements Test3{
	
	
	public static void main(String[] args) {
		TestOops5 testOops5 = new TestOops5();
		testOops5.test();
	}

}
