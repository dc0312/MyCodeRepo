package overLoadingOverRiddingPractice.oops4;

class Animal{
	public void eat() {
		System.out.println("Animal eats.");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("Dog eats.");
	}
}
public class TestOops4 {
	
	public static void test(Animal a) {
		System.out.println("Animal Method called.");
	}
	
	public static void test(Dog a) {
		System.out.println("Dog Method called.");
	}

	public static void main(String[] args) {
		Animal a = new Animal();
		Dog d = new Dog();
		Animal a1 = new Dog();

		test(a);
		test(d);
		test(a1);
		
	}

}
