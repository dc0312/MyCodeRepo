package threads;

public class BankAccount {
	
	public static int accountNo;
	public static double balance;
	
	public BankAccount(int accountNo,double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public static void main(String[] args) {
		BankAccount ba = new BankAccount(2345, 1000.0);
		System.out.println("Initial Balance : "+ba.balance);
		
		new Thread(() -> withDraw()).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				deposit();
			}
		}).start();
	}
	
	public static synchronized boolean deposit() {
		double amt = 500.0;
		if(amt < 0.0) {
			return false;
		}else {
			balance = balance + amt; 
		}
		System.out.println("Balance After Deposit : "+balance);
		return true;
	}
	
	public static synchronized boolean withDraw() {
		double withAmt = 400;
		if(withAmt < 0.0) {
			return false;
		}else {
			balance = balance - withAmt;
		}
		System.out.println("Balance After Withdrawl : "+balance);
		return false;
	}

}
