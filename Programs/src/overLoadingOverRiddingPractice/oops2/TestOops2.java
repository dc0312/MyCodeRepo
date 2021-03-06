package overLoadingOverRiddingPractice.oops2;
class Horse implements Flyer,Mythical {
	public void test() {
		System.out.println("I am a horse");
	}
}

interface Flyer{
	default void test() {
		System.out.println("I can fly.");
	}
}

interface Mythical{
	default void test() {
		System.out.println("I am mythical.");
	}
}
public class TestOops2 {
	
	public static void main(String[] args) {
		Horse oops2 = new Horse();
		oops2.test();
	}
	//If we will not give any default implementation then it will give us compile time error.
	//@Override
	/*public void test() {
		Flyer.super.test();//to call the interface methods
		Mythical.super.test();
		System.out.println("Overridden Test Class.");
	}*/

}
