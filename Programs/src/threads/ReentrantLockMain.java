package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Display{
	ReentrantLock  l = new ReentrantLock();
	
	public void wish(String name) throws InterruptedException {
		if(l.tryLock(6000,TimeUnit.MILLISECONDS)) {
			for(int i =0;i<5;i++) {
				System.out.print("Good Morning : ");
				try {
					Thread.sleep(1000);
					System.out.println(name);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			l.unlock();
			System.out.println("Releases The Lock");
		}else {
			System.out.println(Thread.currentThread().getName()+ " working");
		}
		
	}
}

class MyThread extends Thread{
	Display d;
	String name;
	
	public MyThread(Display d,String name) {
		this.d = d;
		this.name = name;
	}
	 
	@Override
	public void run() {
		try {
			d.wish(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class ReentrantLockMain {
	
	public static void main(String[] args) {
		Display d = new Display();
		MyThread t1 = new MyThread(d, "Deepak");
		MyThread t2 = new MyThread(d, "Aditya");
		
		t1.start();
		t2.start();
	}

}
