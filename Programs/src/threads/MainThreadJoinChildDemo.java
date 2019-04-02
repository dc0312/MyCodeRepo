package threads;
class MyRunnable2 implements Runnable{
	static Thread mt;

	@Override
	public void run() {
		try {
			mt.join(3000);
		}catch (InterruptedException e) {
		}
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}

public class MainThreadJoinChildDemo {
	public static void main(String[] args) {
		MyRunnable2.mt = Thread.currentThread();
		MyRunnable2.mt.setName("Main");
		MyRunnable2 r2 = new MyRunnable2();
		Thread t = new Thread(r2);
		
		t.start();
		
		for(int i=0;i<5;i++) {
			try {
				MyRunnable2.mt.sleep(500);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println(MyRunnable2.mt.getName());
		}
	}
}
