package overLoadingOverRiddingPractice;
class A{
	public static void display() {
		System.out.println("A");
	}
}

class B extends A{
	public static void display() {
		System.out.println("B");
	}
}
public class Main1 {
	public static void main(String[] args) {
		A a = new B();
		a.display();
		print(a);
	}
	
	public static void print(A a) {
		System.out.println("A");
	}
	
	public static void print(B b) {
		System.out.println("B");
	}
}
