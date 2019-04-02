package threads;
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getPriority()+" chlid");
		for(int i =0;i<20;i++) {
			System.out.println(Thread.currentThread().getName()+" child");
			Thread.yield();
		}
		
	}
	
}
public class YieldDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" main");
		System.out.println(Thread.currentThread().getPriority() + " Main");
		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r, "Thread-1");
		Thread t2 = new Thread(r,"Thread-2 ");
		Thread t3 = new Thread(r,"Thread-3 ");
		
		t1.start();
		t1.setPriority(2);
		t2.start();
		t3.start();
		
		for(int i=0;i<20;i++) {
			Thread.yield();
			System.out.println(Thread.currentThread().getName()+" main");
		}
	}
}
