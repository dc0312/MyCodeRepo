package overLoadingOverRiddingPractice;

class Animal {
	
	static String name = "Animal";
	
	public Animal() {
		System.out.println("Animal Class Constructor called.");
	}
	public Animal(String name) {
		this.name = name;
		System.out.println("Static name called");
	}
	public void eat() {
		System.out.println("Animal eats");
	}
}

class Dog extends Animal{
	
	public Dog() {
		super(Animal.name);
		System.out.println("Dog constructor called.");
	}
	public void eat() {
		System.out.println("Dog eats.");
	}
	
	public  void eat(String eat) {
		System.out.println("Overloaded Method : Dog eats");
	}
}
public class OverLoadingOverRiddingTest {
	public static void main(String[] args) {
		
		Animal a = new Animal();
		System.out.println("========");
		Dog d = new Dog();
		Animal a1 = new Dog();
		
		a.eat();//Animal eats
		d.eat();//Dog eats
		//a.eat("grass"); compile time error
		//a1.eat();//Dog eats
		//a1.eat("grass"); compile time error
		d.eat("grass");//Overloaded Method : Dog eats
		
		
		
		
	}
}
