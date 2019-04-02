package programs;
class Animal10{
	
	@Override
	 public boolean equals(Object o) {
		 if(o.getClass() == this.getClass()) {
			 return true;
		 }
		 return false;
	 }
	
}
class Dog10 extends Animal10{
	 @Override
	 public boolean equals(Object o) {
		 if(o.getClass() == this.getClass()) {
			 return true;
		 }
		 return false;
	 }
}

public class Equaloveridding {
	 public static void main(String[] args) {
		Animal10 a = new Animal10();
		Dog10 d = new Dog10();
		
		System.out.println("d.equals(a) "+ d.equals(a));
		System.out.println("a.equals(d) "+a.equals(d));
	}
}
