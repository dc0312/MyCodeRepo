package overLoadingOverRiddingPractice.oops8;

class Animal{
	public void eat() {
		System.out.println("Anmimal eats.");
	}
}


class Horse extends Animal{
	
	public void eat() {
		System.out.println("Horse eat.");
	}
	
	public void buck() {
		System.out.println("Buck method called.");
	}
}

public class TestOops8{
	public static void main(String[] args) {
		Animal a = new Animal();
		Horse d = new Horse();
		Animal a1 = new Horse();
		
		a.eat();
		d.eat();
		d.buck();
		a1.eat();
		//Animal class doesnt have the buck method. So at compile time it will fail.
		//a1.buck();
		
	}
}
