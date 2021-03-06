package threads;

public class SystemThreadGroup {
	
	public static void main(String[] args) {
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		
		Thread [] t = new Thread[system.activeCount()];
		system.enumerate(t);
		for (Thread thread : t) {
			System.out.println(thread.getName() +" "+thread.isDaemon());
		}
	}

}
