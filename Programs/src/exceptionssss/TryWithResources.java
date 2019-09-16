package exceptionssss;

public class TryWithResources {
	 
	public static void main(String[] args) throws Exception{
		//Here we can put the files that implements the Autoclosable interface.
		/*try ( FileInputStream fileInputStream = new FileInputStream("data/impPrograms.txt")){
			
			 int data = fileInputStream.read();
			 while(data != -1) {
				 data = fileInputStream.read();
				 System.out.println(data);
			 }
			
		} */
		try {
			workOnResource();
		}catch (Exception e) {
			e.printStackTrace();
			//this print stack will have only finally block exception and in suppressed exception, we will
			// not get any exception
		}
		
		
	}
	
	public static void workOnResource() throws Exception {
		try(AutoCloseableResource resource1 = new AutoCloseableResource("One",true);
				AutoCloseableResource resource2 = new AutoCloseableResource("two", false)){
			resource1.doOp(true);
			resource2.doOp(false);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally");
			throw new Exception("Finally Block throwing the error");
		}
	}
}
