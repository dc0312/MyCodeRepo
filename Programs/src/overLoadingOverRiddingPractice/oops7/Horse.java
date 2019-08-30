package overLoadingOverRiddingPractice.oops7;

class Animal{
	public void eat() {
		System.out.println("Anmimal eats.");
	}
}


public class Horse extends Animal{
	//this will not compile as we cannot decrease the visibility of the method.
	/*private void eat() {
		System.out.println("Horse eats.");
	}*/
	
	public static void main(String[] args) {
		
	}

}
