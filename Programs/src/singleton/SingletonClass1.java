package singleton;

class Singleton1 {
	
	public static final Singleton1 S_I = new Singleton1();
	
	private Singleton1() {
		// TODO Auto-generated constructor stub
	}
	
}

public class SingletonClass1 {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.S_I;
		Singleton1 s2 = Singleton1.S_I;
		System.out.println(s1==s2);
		
	}
}
