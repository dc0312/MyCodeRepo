package exceptionssss;

class BadNumberException extends Exception {
	BadNumberException(String s) {
		System.out.println(s);
	}
}

public class ExceptionPropagation {

	public static int divide(int numberToDivide, int numberToDivideBy) throws BadNumberException {
		if (numberToDivideBy == 0) {
			throw new BadNumberException("Cannot divide by 0");
		}
		return numberToDivide / numberToDivideBy;
	}
	
	/*public static void callDivide(){
        try {
            int result = divide(2,0);
            System.out.println(result);
        } catch (BadNumberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Division attempt done");
    }*/
	
	public static void callDivide() throws BadNumberException{
        int result = divide(2,0);
        System.out.println(result);
    }
	
	public static void main(String[] args) throws BadNumberException {
		callDivide();
	}
}
