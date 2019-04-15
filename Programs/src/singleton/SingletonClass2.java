package singleton;

public class SingletonClass2 {
	
	public static void test(Object o) {
		System.out.println("Object Called");
	}
	
	public static void test(String s) {
		System.out.println("String Called");
	}
	
	public static void main(String[] args) {
		Singleton4 s1 = Singleton4.INSTANCE;
		s1.value=10;
		
		System.out.println(s1.value);
		
		Singleton4 s2 = Singleton4.INSTANCE;
		s2.value =20;
		System.out.println(s2.value);
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		test(null);
		
	}
}
