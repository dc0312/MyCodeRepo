package overLoadingOverRiddingPractice.oops1;
class Animal{
    int i =20;
	public static void testClassMethod() {
		System.out.println("The Static method in Animal");
	}
	
	public void testInstanceMethod() {
		System.out.println("The Instance Method in Animal");
	}
}

class Cat extends Animal{
    int i =10;
	public static void testClassMethod() {
		System.out.println("The Static method in Cat");
	}
	
	public void testInstanceMethod() {
		System.out.println("The Instance Method in Cat");
	}
}
public class TestOops1 {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		Cat cat = new Cat();
		Animal animal1 = new Cat();
		
		animal.testInstanceMethod();
		cat.testInstanceMethod();
		animal1.testInstanceMethod();
		
		animal.testClassMethod();
		cat.testClassMethod();
		animal1.testClassMethod();
		
		System.out.println(animal1.i);
	}

}
