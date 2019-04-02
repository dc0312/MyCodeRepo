package programs;

class Animal1{
	private String name;
	public void eat() {
		System.out.println("Animal eat.");
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}

class Dog1 extends Animal1{
	private String dogBreed;
	public void eat() {
		System.out.println("Dog eat.");
	}
	
	public void bark() {
		System.out.println("Dog bark.");
	}

	/**
	 * @return the dogBreed
	 */
	public String getDogBreed() {
		return dogBreed;
	}

	/**
	 * @param dogBreed the dogBreed to set
	 */
	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	
}

public class TypeCasting {
	
	final static int num;
	static {
		num =10;
	}
	
	public static void test(Dog1 a) {
		System.out.println("Dog1 Called");
	}
	
	public static void test(Animal1 a) {
		System.out.println("Animal Called");
	}
	
	public static void main(String[] args) {
		Animal1 a1 = new Animal1();
		Dog1 d1 = new Dog1();
		
		a1.eat();
		d1.eat();
		d1.bark();
		
		//((Dog1) a1).bark(); Animal1 cannot be cast to programs.Dog1
		
		Animal1 a2 = new Dog1();
		a2.eat();
		((Dog1) a2).bark();
		
		a1.getName();
		((Dog1) a2).getDogBreed();
		
		test(null);
	}
}
