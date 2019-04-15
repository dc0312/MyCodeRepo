package singleton;

class Singleton {
	
	private static Singleton S_I = null;
	
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance() {
		if(S_I == null) {
			S_I = new Singleton();
			return S_I;
		}
		return S_I;
	}
	
}

public class SingletonClass{
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1==s2);
	}
}
