package overLoadingOverRiddingPractice.oops3;
class Horse{
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
public class TestOops3 extends Horse implements Flyer,Mythical {
	
	public static void main(String[] args) {
		TestOops3 oops2 = new TestOops3();
		oops2.test();
	}

}
