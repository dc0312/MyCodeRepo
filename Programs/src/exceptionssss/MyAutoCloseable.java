package exceptionssss;

public class MyAutoCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("My AutoCloseable is closed.");
	}

}
