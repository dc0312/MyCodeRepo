package threads;
class MyRunnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
}
public class ThreadJoinDemo {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 r1 = new MyRunnable1();
		Thread t = new Thread(r1,"Thread 1");
		
		t.start();
		
		/*for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName() +" upar");
		}*/
		
		t.join();
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+" neeche");
		}
	}
}
