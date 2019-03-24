package exceptionssss.programs;

public class AutoCloseableResource implements AutoCloseable {
	
	private String name= null;
	private boolean throwException = false;
	public AutoCloseableResource(String name, boolean throwException) {
		this.name = name;
		this.throwException = throwException;
	}
	
	public void doOp(boolean throwException) throws Exception{
		System.out.println("Resource " + name +" Doing Operation");
		if(throwException) {
			throw new Exception("Error when calling doOp() on resource " + this.name);
		}
	}

	@Override
    public void close() throws Exception {
        System.out.println("Resource " + this.name + " close() called");
        if(this.throwException){
            throw new Exception("Error when trying to close resource " + this.name);
        }
    }

}
