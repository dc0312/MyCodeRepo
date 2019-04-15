package exceptionssss.programs;

public class TryWithResources2 {
	
	public static void main(String[] args) {
		try (MyAutoCloseable autoCloseable = new MyAutoCloseable()){
			System.out.println("Inside try block");
			throw new Exception("Exception Thrown");
		} catch (Exception e) {
			System.out.println("catch called");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("finally called");
		}
		
	}
	
	
	

}
